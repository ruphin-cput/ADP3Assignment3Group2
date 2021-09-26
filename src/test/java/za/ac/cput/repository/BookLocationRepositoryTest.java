package za.ac.cput.repository;

/**
 * bookLocationRepositoryTest.java
 *
 * @author: Melven Johannes Booysen (219201277)
 * Date: 25 August 2021
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.BookLocation;
import za.ac.cput.factory.BookLocationFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class BookLocationRepositoryTest
{
    private static BookLocationRepository repository = BookLocationRepository.getRepository();
    private static BookLocation bookLocation = BookLocationFactory. createBookLocation("4", "8");

    @Test
    void create()
    {
        BookLocation created = repository.create(bookLocation);
        assertEquals(created.getGenreId(), bookLocation.getGenreId());
        System.out.println("Created: " + created);
    }

    @Test
    void read()
    {
        BookLocation read = repository.read(bookLocation.getGenreId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update()
    {
        BookLocation updated = new BookLocation.Builder().copy(bookLocation).setGenreId("10").build();
        assertEquals(updated,repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete()
    {
        boolean success = repository.delete(bookLocation.getGenreId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void getAll()
    {
        System.out.println("Showing all: ");
        System.out.println(repository.getAll());
    }
}

