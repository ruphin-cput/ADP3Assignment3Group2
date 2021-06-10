package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;

import za.ac.cput.Entity.UserRole;

import static org.junit.jupiter.api.Assertions.*;
/*  UserRoleFactoryTest.java
    Factory Test for the UserRole entity
    Author: Adriaan Burger(219014868)
    Date: 10 June 2021
 */
class UserRoleFactoryTest {
    @Test
    public void createUserRole(){

        UserRole userRole = UserRoleFactory.createUserRole();
        System.out.println(userRole);
        assertNotNull(userRole);
    }

}