package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.User;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/*  UserFactoryTest.java
    Factory Test for the User entity
    Author: Adriaan Burger(219014868)
    Date: 11 June 2021
 */
class UserFactoryTest {
    private User user1, user2;


    @Test
    public void createUser(){
        user1 = UserFactory.createUser("Heitor","Villa-Lobos","0713325511","villalobos@guitarist.com",null);
        user2 = UserFactory.createUser("Astor","Piazolla","0711028701","astor@guitarist.com",null);
        System.out.println(user1);
        System.out.println(user2);
        assertNotNull(user1);
    }

    @Test
    public void testEqual(){
        assertEquals(user1, user2);
    }

    @Test
    public void testIdent(){
        assertSame(user1, user2);
    }

    @Test
    @Timeout(value = 110, unit = TimeUnit.MILLISECONDS)
    void testTime(){
        createUser();
    }

    @Test
    @Disabled
    void testSandbox(){
        //ideas/incomplete tests go here
        createUser();
    }

}