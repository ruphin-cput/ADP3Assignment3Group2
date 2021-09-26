package za.ac.cput.service.impl;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.UserLogin;
import za.ac.cput.factory.UserLoginFac;
import za.ac.cput.service.impl.UserLoginService;

import static org.junit.jupiter.api.Assertions.*;

public class UserLoginServiceTest {
    private static UserLoginService service = UserLoginService.getService();
    private static UserLogin login = UserLoginFac.createLogin("T.Boltman","2468");

    @Test
    void U_create() {
        UserLogin created = service.create(login);
        assertEquals(created.getUserId(), login.getUserId());
        System.out.println("Created: " + created);
    }

    @Test
    void U_read() {
        UserLogin read = service.read(login.getUserId());
        assertNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void U_update(){
        UserLogin updated = new UserLogin.Builder().copy(login).setPassword("12345").build();
        assertEquals(updated,service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void U_delete(){
        boolean success = service.delete(login.getUserId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void U_getAll(){
        System.out.println("Showing all: ");
        System.out.println(service.getAll());
    }



}
