package za.ac.cput.factory;

import za.ac.cput.entity.UserLogin;
import za.ac.cput.util.GenericHelper;

public class UserLoginFac {
    public static UserLogin createLogin(String userName, String password){

        if(userName.isEmpty() || password.isEmpty()){
            return null;
        }

        String userId = GenericHelper.generateId();

        UserLogin login = new UserLogin.Builder()
                .setUserId(userId)
                .setUserName(userName)
                .setPassword(password)
                .build();

        return login;
    }
}
