public enum Language {
    ENGLISH("English"),
    INDONESIAN("Indonesian"),
    SPANISH("Spanish"),
    JAPANESE("Japanese");

    private String language;

    Language(String language) {
        this.language = language;
    }

    public String toString(){
        return language;
    }
}
