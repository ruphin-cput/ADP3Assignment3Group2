package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Role;
import za.ac.cput.entity.User;
import za.ac.cput.entity.UserRole;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
/*  UserRoleFactoryTest.java
    Factory Test for the UserRole entity
    Author: Adriaan Burger(219014868)
    Date: 11 June 2021
 */
class UserRoleFactoryTest {
    private UserRole userRole1, userRole2;
    @Test
    public void createUserRole(){

        User user1 = UserFactory.createUser("Heitor","Villa-Lobos","0713325511","villalobos@guitarist.com","That Street");
        Role role1 = RoleFactory.createRole("student",null);
        userRole1 = UserRoleFactory.createUserRole(user1,role1);

        User user2 = UserFactory.createUser("Astor","Piazolla","0711028701","astor@guitarist.com","That other Street");
        Role role2 = RoleFactory.createRole("student",null);
        userRole2 = UserRoleFactory.createUserRole(user2,role2);

        System.out.println(userRole1);
        System.out.println(userRole2);
        assertNotNull(userRole1);
        assertNotNull(userRole2);
    }
    @Test
    public void testEqual(){
        assertEquals(userRole1, userRole2);
    }

    @Test
    public void testIdent(){
        assertSame(userRole1, userRole2);
    }

    @Test
    @Timeout(value = 110, unit = TimeUnit.MILLISECONDS)
    void testTime(){
        createUserRole();
    }

    @Test
    @Disabled
    void testSandbox(){
        //ideas/incomplete tests go here
        createUserRole();
    }



}