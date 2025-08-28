import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> userMap = new HashMap<>();
    private User currUser = null;

    public boolean registerUser(String userName,String password,String fullName,String contact,String address){
        if(userMap.containsKey(userName))
        {
            System.out.println("Username already taken, Please choose another");
            return false;
        }
        User user = new User(userName,password,fullName,contact,address);
        System.out.println("Registered successful");
        return true;
    }
    public boolean loginUser(String userName,String password){
        if(userMap.containsKey(userName))
        {
            System.out.println("No user found with this username");
            return false;
        }

        User user = userMap.get(userName);
        if(!user.getPassword().equals(password)){
            System.out.println("Incorrect password");
            return false;
        }
        currUser = user;
        System.out.println("Welcome: "+ currUser.getFullName() + "!");
        return true;
    }
   private void logoutUser(){
        if(currUser != null){
            System.out.println("logged Out "+ currUser.getFullName());
        }
        currUser = null;
   }

    public User getCurrUser() {
        return currUser;
    }
    public boolean isloging(){
        return currUser != null;
    }
}
