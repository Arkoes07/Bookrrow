public enum BookType {
    FICTION("Fiction"),
    NONFICTION("Non-fiction");

    private String bookType;

    BookType(String bookType) {
        this.bookType = bookType;
    }

    public String toString(){
        return bookType;
    }
}
