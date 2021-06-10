package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Role;

import static org.junit.jupiter.api.Assertions.*;
/*  RoleFactoryTest.java
    Factory Test for the Role entity
    Author: Adriaan Burger(219014868)
    Date: 10 June 2021
 */

class RoleFactoryTest {
    @Test
    public void createRole(){
        Role role = RoleFactory.createRole("student",null);
        System.out.println(role);
        assertNotNull(role);
    }

}