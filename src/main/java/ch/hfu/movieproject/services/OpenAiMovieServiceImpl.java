package ch.hfu.movieproject.services;

import ch.hfu.movieproject.common.Language;
import ch.hfu.movieproject.common.Movie;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class OpenAiMovieServiceImpl implements OpenAIMovieService {

    ChatModel chatModel;

    @Autowired()
    @Qualifier(value = "OpenAi")
    public void setChatModel(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @Override
    public String getIntro(Movie movie, Language language) {

        StringBuilder sb = new StringBuilder()
                .append(String.format("Write a short spoiler-free introduction for the movie named: '%s' released in the year: %s.", movie.getTitle(), movie.getYear()))
                .append(language.toString())
                .append("The introduction should be about 200 - 300 words. ")
                .append("Do not translate the title of the movie, if it is the same in the target language.")
                .append("Do mention, who directed the movie, main actors and who was responsible for the music.")
                .append("do not translate words, that are usually kept in their original language.")
                .append(String.format("if there is no such movie, you can answer with: 'no information found about %s from %s' (translate, if applicable).", movie.getTitle(), movie.getYear()))
                ;
        String promptString = sb.toString();

        String introduction = "";

        try {
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                Prompt prompt = new Prompt(promptString);

                ChatResponse response = chatModel.call(prompt);
                return response.getResult().getOutput().getContent();
            });

            introduction = future.get();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return introduction;
    }
}
