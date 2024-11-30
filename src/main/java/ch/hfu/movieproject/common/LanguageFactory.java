package ch.hfu.movieproject.common;

import java.util.Locale;

public class LanguageFactory {
    public static Language fromLocale(Locale locale){
        return switch (locale.getLanguage()) {
            case "en" -> Language.EN;
            case "de" -> Language.DE;
            default -> throw new RuntimeException("Language not implemented yet " + locale.getLanguage());
        };
    }

}
