package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.User;

import static org.junit.jupiter.api.Assertions.*;

/*  UserFactoryTest.java
    Factory Test for the User entity
    Author: Adriaan Burger(219014868)
    Date: 10 June 2021
 */
class UserFactoryTest {
    @Test
    public void createUser(){
        User user = UserFactory.createUser("Heitor","Villa-Lobos","0713325511","villalobos@guitarist.com",null);
        System.out.println(user);
        assertNotNull(user);
    }

}