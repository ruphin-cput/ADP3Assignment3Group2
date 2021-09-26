package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.User;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;
/*  UserServiceTest.java
    User Service tests
    Author: Adriaan Burger(219014868)
    Date: 27 July 2021
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService service;

    private static User user = UserFactory.createUser("Carlo","Domeniconi","0124489558","koyunbaba@guitar.suite","Italy");
    private static User user2 = UserFactory.createUser("Astor","Piazolla","05511945887","astor@guitar.suite","Out of This World");
    // Copy + Paste ID string into test cases for read, update, delete after the create test case is run
    @Test
    void a_create(){
        User created = service.create(user);
        assertEquals(created.getUserID(),user.getUserID());
        System.out.println("Created: " + created);
    }
    @Test
    void b_read(){
        User read = service.read("2b17a89a-e6db-4d34-b7ac-0846a2193379");
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update(){
        User old = service.read("2b17a89a-e6db-4d34-b7ac-0846a2193379");
        User updated = new User.Builder().copy(old).setAddress("The New Istanbul University State Conservatory").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_getAll(){
        System.out.println("Showing all: ");
        System.out.println(service.getAll());
    }

    @Test
    void e_delete(){
        boolean success = service.delete("251b487a-7b9f-42be-a7dc-3672db4ede93");
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

}