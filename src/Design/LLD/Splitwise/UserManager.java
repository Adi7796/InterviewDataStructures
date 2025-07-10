package Design.LLD.Splitwise;

import java.util.HashMap;
import java.util.Map;

public class UserManager {

    private static UserManager userManager;

    private UserManager(){};
    private Map<Integer, User> userMap = new HashMap<>();

    public static UserManager getUserManagerInstance()
    {
        if(userManager == null)
        {
            userManager = new UserManager();
        }
        return userManager;
    }

    public void addUser(User user){
        userMap.put(user.getUserId(), user);
    }

    public User getUser(int id){
        return userMap.get(id);
    }

    public void removeUser(User user){
        userMap.remove(user.getUserId());
    }
}
