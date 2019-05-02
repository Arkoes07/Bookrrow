public class UserNotFoundException extends Exception {
    private int user_error;

    public UserNotFoundException(int customer_input) {
        super("User ID: ");
        this.user_error = customer_input;
    }

    public String getExMessage(){
        return super.getMessage()+user_error+" not found.\n\n";
    }
}
