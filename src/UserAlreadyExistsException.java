public class UserAlreadyExistsException extends Exception {
    private User user_error;

    public UserAlreadyExistsException(User user_input) {
        super("User email: ");
        this.user_error = user_input;
    }

    public String getExMessage(){
        return "===============CUSTOMER ALREADY EXISTS===============\n"+super.getMessage()+user_error.getEmail()+", or Username: "+user_error.getUsername()+" already exists.\n\n";
    }
}
