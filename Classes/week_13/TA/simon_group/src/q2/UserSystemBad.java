package q2;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represent a User-System of Aplication There must be one Object of thic class.
 */
public class UserSystemBad {

    private Map<String,String> users;

    public UserSystemBad(){
        users= new HashMap<>();

    }

    public void addUser(String userName,String password){
        users.put(userName,password);

    }

    public boolean isAuthorized(String usrename , String password){

        if(!users.containsKey(usrename)) return  false;

        return users.get(usrename).equals(password);
    }


    public static void main(String[] args) {

        UserSystemBad userSystemOne = new UserSystemBad();
        userSystemOne.addUser("Simon","111");
        userSystemOne.addUser("yosi","222");
        System.out.println(userSystemOne.isAuthorized("Simon","111"));
        UserSystemBad userSystemTwo = new UserSystemBad();
        userSystemTwo.addUser("Vasia","222");
        System.out.println(userSystemOne.isAuthorized("Vasia","222"));


    }

}
