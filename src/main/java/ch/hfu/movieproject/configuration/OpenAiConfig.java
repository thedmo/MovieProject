package ch.hfu.movieproject.configuration;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAiConfig {
    @Bean
    public OpenAiChatOptions openAiChatOptions() {
        return OpenAiChatOptions
                .builder()
                .withModel("gpt-4o")
                .withTemperature(0.4)
                .build();
    }

    @Value("${spring.ai.openai.api-key}")
    private String apiKey;

    @Bean("OpenAi")
    public ChatModel setChatModel( OpenAiChatOptions options) {
        OpenAiApi api = new OpenAiApi("https://api.openai.com", apiKey);
        return new OpenAiChatModel(api, options);
    }
}
