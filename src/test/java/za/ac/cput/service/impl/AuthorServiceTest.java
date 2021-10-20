package za.ac.cput.service.impl;

/**
 * authourServiceTest.java
 *
 * @author: Melven Johannes Booysen (219201277)
 * Date: 25 August 2021
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Author;
import za.ac.cput.factory.AuthorFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class AuthorServiceTest
{
    @Autowired
    private AuthorService service;
    private static Author author = AuthorFactory.createAuthor(
            "Nelson",
            "Mandela",
            "Nelson Mandela, in full Nelson Rolihlahla Mandela, byname Madiba," +
            " (born July 18, 1918, Mvezo, South Africa—died December 5, 2013, Johannesburg), Black nationalist and the first Black president of South Africa (1994–99). " +
            " His negotiations in the early 1990s with South African Pres."
    );

    @Test
    void a_create()
    {
        System.out.println(author.getAuthorId());
        Author created = service.create(author);
        assertEquals(created.getAuthorId(),author.getAuthorId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read()
    {
        Author read = service.read(author.getAuthorId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update()
    {
        Author old = service.read(""); // Need to get an Id from the database (workbench)
        Author updated = new Author.Builder().copy(author).setName("Rolihlahla").build();
        System.out.println();
//      assertSame(updated, service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete()
    {
        boolean success = service.delete(author.getAuthorId()); // Need to get an Id from the database (workbench)
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll()
    {
        System.out.println("Showing all: ");
        System.out.println(service.getAll());
    }
}//** End of AuthorServiceTest **
