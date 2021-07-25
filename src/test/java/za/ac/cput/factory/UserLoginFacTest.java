package za.ac.cput.factory;

/*  UserLoginFacTest.java
    User login entity factory test
    Author: Taahir Boltman(218022972)
    Date: 10 June 2021
 */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.UserLogin;
import za.ac.cput.factory.UserLoginFac;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class UserLoginFacTest {

    private UserLogin login;
    private UserLogin login1;

    @Test
    public void createLogin(){
        login = UserLoginFac.createLogin("T.Boltman", "abracadabra");
        login1 = UserLoginFac.createLogin("A.Fisher", "hocuspocus");

        System.out.println(login);
        System.out.println(login1);
    }

    @Test
    void TestEquality(){
        assertEquals(login,login1);
    }

    @Test
    void TestIdentity(){
        assertSame(login,login1);
    }

    @Test
    @Timeout(value= 100, unit = TimeUnit.MILLISECONDS)
    void TestTimeout(){
        createLogin();
    }

    @Test
    @Disabled
    void TestDisabled(){
        createLogin();
    }
}
