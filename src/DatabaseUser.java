import java.util.ArrayList;

public class DatabaseUser
{
    private static final ArrayList<User> USER_DATABASE = new ArrayList<>();
    private static int LAST_USER_ID = 0;

    public static int getLastUserId(){
        return LAST_USER_ID;
    }

    public static boolean addUser(User user) throws UserAlreadyExistsException {
        String userName = user.getUsername();
        String email = user.getEmail();
        for ( User temp : USER_DATABASE){
            if(email.equals(temp.getEmail()) || userName.equals(temp.getUsername())){
                throw new UserAlreadyExistsException(temp);
            }
        }
        USER_DATABASE.add(user);
        LAST_USER_ID = user.getId();
        return true;
    }

    public static User getUser(int id)
    {
        for ( User temp : USER_DATABASE ){
            if (temp.getId() == id) {
                return temp;
            }
        }
        return null;
    }

    public static boolean removeUser(int id) throws UserNotFoundException {
        for ( User temp : USER_DATABASE ){
            if (temp.getId() == id) {
                USER_DATABASE.remove(temp);
                return true;
            }
        }
        throw new UserNotFoundException(id);
    }

    public static User getUserLogin(String email, String password){
        for(User temp : USER_DATABASE){
            if(temp.getEmail().equals(email) && temp.getPassword().equals(password)){
                return temp;
            }
        }
        return null;
    }

    public static ArrayList<User> getUserDatabase(){
        return USER_DATABASE;
    }
}