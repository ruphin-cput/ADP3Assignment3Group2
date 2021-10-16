package za.ac.cput.service.impl;

/**
 * bookLocationTest.java
 *
 * @author: Melven Johannes Booysen (219201277)
 * Date: 25 August 2021
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.BookLocation;
import za.ac.cput.factory.BookLocationFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class BookLocationServiceTest
{
    @Autowired
    private static BookLocationService service;
    private static BookLocation bookLocation = BookLocationFactory. createBookLocation("4", "8");

    @Test
    void create()
    {
        BookLocation created = service.create(bookLocation);
        assertEquals(created.getGenreId(), bookLocation.getGenreId());
        System.out.println("Created: " + created);
    }

    @Test
    void read()
    {
        BookLocation read = service.read(bookLocation.getGenreId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update()
    {
        BookLocation old = service.read(""); // Need to get an Id from the database (workbench)
        BookLocation updated = new BookLocation.Builder().copy(bookLocation).setGenreId("10").build();
        assertEquals(updated,service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete()
    {
        boolean success = service.delete(""); // Need to get an Id from the database (workbench)
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void getAll()
    {
        System.out.println("Showing all: ");
        System.out.println(service.getAll());
    }
}
