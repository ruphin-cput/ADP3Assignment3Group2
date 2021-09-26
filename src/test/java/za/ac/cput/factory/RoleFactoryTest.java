package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Role;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
/*  RoleFactoryTest.java
    Factory Test for the Role entity
    Author: Adriaan Burger(219014868)
    Date: 11 June 2021
 */

class RoleFactoryTest {
    private Role role1, role2;

    @Test
    public void createRole(){
        role1 = RoleFactory.createRole("student",null);
        role2 = RoleFactory.createRole("librarian",null);
        System.out.println(role1);
        System.out.println(role2);
        assertNotNull(role1);
        assertNotNull(role2);
    }

    @Test
    public void testEqual(){
        assertEquals(role1, role2);
    }

    @Test
    public void testIdent(){
        assertSame(role1, role2);
    }

    @Test
    @Timeout(value = 110, unit = TimeUnit.MILLISECONDS)
    void testTime(){
        createRole();
    }

    @Test
    @Disabled
    void testSandbox(){
        //ideas/incomplete tests go here
        createRole();
    }


}