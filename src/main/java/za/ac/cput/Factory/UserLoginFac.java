package za.ac.cput.Factory;

/*  UserLoginFac.java
    User Login entity factory
    Author: Taahir Boltman(218022972)
    Date: 10 June 2021
 */

import za.ac.cput.Entity.UserLogin;
import za.ac.cput.Util.GenericHelper;

public class UserLoginFac {

    public static UserLogin createLogin(String userName, String password){

        String userId = GenericHelper.generateId();

        UserLogin login = new UserLogin.Builder()
                .setUserId(userId)
                .setUserName(userName)
                .setPassword(password)
                .build();

        return login;
    }
}
