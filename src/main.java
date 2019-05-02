public class main {
    public static void main(String[] args){
        try {
            DatabaseUser.addUser(new User("frenzel","frenzel01@gmail.com","frenzelts","password"));
            DatabaseUser.addUser(new User("frenzel 2","frenzeltsurya@gmail.com","frenzeltssss","password"));
        } catch (UserAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
        Author author = new Author("Zidan", "Depok","zidankun@gmail.com");
        try {
            DatabaseBook.addBook(new Fiction("Buku Fiksi", "Part 2", Genre.SCIFI,author,Language.JAPANESE,1990, DatabaseUser.getUser(1)));
        } catch (BookAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
        try {
            DatabaseBook.addBook(new NonFiction("Buku NonFiksi", "Part 3",author,Language.ENGLISH,2009, DatabaseUser.getUser(1)));
        } catch (BookAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }

        try {
            DatabaseTransaction.addTransaction(new Transaction(DatabaseBook.getBookFromId(1), DatabaseUser.getUser(2)));
        } catch (BookAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
        DatabaseTransaction.getTransactionFromId(1).returnBook();
        System.out.println(DatabaseBook.getBookDatabase());

    }
}
