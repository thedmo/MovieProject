package ch.hfu.movieproject.configuration;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.model.function.FunctionCallback;
import org.springframework.ai.model.function.FunctionCallbackContext;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.ai.ollama.management.ModelManagementOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ai.ollama.OllamaChatModel;
import io.micrometer.observation.ObservationRegistry;

import java.util.Collections;
import java.util.List;

@Configuration
public class OllamaConfig {

    @Bean
    public OllamaApi ollamaApi() {
        return new OllamaApi("http://localhost:11434");
    }

    @Bean
    public OllamaOptions ollamaOptions() {
        return OllamaOptions.create()
                .withModel("llama3.2-vision")
                .withTemperature(.7);
    }

    @Bean
    public FunctionCallbackContext functionCallbackContext() {
        return new FunctionCallbackContext();
    }

    @Bean
    public List<FunctionCallback> toolFunctionCallbacks() {
        return Collections.emptyList();
    }

    @Bean
    public ObservationRegistry observationRegistry() {
        return ObservationRegistry.create();
    }

    @Bean
    public ModelManagementOptions modelManagementOptions() {
        return ModelManagementOptions.builder().build();
    }

    @Bean("Ollama")
    public ChatModel ollamaChatModel(OllamaApi ollamaApi,
                                     OllamaOptions ollamaOptions,
                                     FunctionCallbackContext functionCallbackContext,
                                     List<FunctionCallback> toolFunctionCallbacks,
                                     ObservationRegistry observationRegistry,
                                     ModelManagementOptions modelManagementOptions) {
        return new OllamaChatModel(
                ollamaApi,
                ollamaOptions,
                functionCallbackContext,
                toolFunctionCallbacks,
                observationRegistry,
                modelManagementOptions);
    }
}
