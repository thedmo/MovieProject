package ch.hfu.movieproject.common;

public enum Language {
    DE,
    EN;


    @Override
    public String toString() {
        return switch (this) {
            case DE -> "\nAnswer only in German.";
            case EN -> "\nAnswer only in English.";
        };
    }
}
