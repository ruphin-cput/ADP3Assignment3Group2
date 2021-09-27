package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Author;
import za.ac.cput.entity.BookLocation;
import za.ac.cput.factory.AuthorFactory;
import za.ac.cput.factory.BookLocationFactory;
import za.ac.cput.repository.AuthorRepository;
import za.ac.cput.repository.BookLocationRepository;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
class BookLocationServiceTest
{
    private static BookLocationRepository service = BookLocationRepository.getRepository();
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
        BookLocation updated = new BookLocation.Builder().copy(bookLocation).setGenreId("10").build();
        assertEquals(updated,service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete()
    {
        boolean success = service.delete(bookLocation.getGenreId());
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
