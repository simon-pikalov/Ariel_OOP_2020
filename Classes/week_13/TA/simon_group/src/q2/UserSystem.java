package q2;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represent a User-System of Aplication There must be one Object of thic class.
 */
public class UserSystem {
    private static UserSystem instance;
    private Map<String,String> users;

    private UserSystem(){
        users = new HashMap<>();
    };

    public static UserSystem getInstance(){

        if (instance == null)
        {
            //synchronized block to remove overhead
            synchronized (UserSystem.class)
            {
                if(instance==null)
                {
                    // if instance is null, initialize
                    instance = new UserSystem();
                }

            }
        }
        return instance;
    }



    public void addUser(String userName,String password){
        users.put(userName,password);

    }

    public boolean isAuthorized(String usrename , String password){

        if(!users.containsKey(usrename)) return  false;

        return users.get(usrename).equals(password);
    }


    public static void main(String[] args) {

        UserSystem userSystem = UserSystem.getInstance();
        userSystem.addUser("Simon","111");
        userSystem.addUser("yosi","222");
        System.out.println(userSystem.isAuthorized("Simon","111"));
        UserSystem userSystem2 = UserSystem.getInstance();
        userSystem2.addUser("Vasia","222");
        System.out.println(userSystem.isAuthorized("Vasia","222"));


    }

}
