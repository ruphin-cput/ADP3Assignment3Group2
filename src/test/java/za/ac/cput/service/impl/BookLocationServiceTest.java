package za.ac.cput.service.impl;

/**
 * bookLocationTest.java
 *
 * @author: Melven Johannes Booysen (219201277)
 * Date: 25 August 2021
 */

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Book;
import za.ac.cput.entity.BookLocation;
import za.ac.cput.entity.Genre;
import za.ac.cput.factory.BookFac;
import za.ac.cput.factory.BookLocationFactory;
import za.ac.cput.factory.GenreFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class BookLocationServiceTest
{
    @Autowired
    private BookLocationService service;
    @Autowired
    private BookService bookService;
    @Autowired
    private GenreService genreService;


    private static Book book;
    private static Genre genre;
    private static Genre anotherGenre;
    private static BookLocation bookLocation ;

    @BeforeAll
    void setup() {
        book = bookService.create(BookFac.createBook("4", "Author", "Book", "DESCRIPTION", "none"));
        genre = genreService.create(GenreFactory.createGenre("Fantasy"));
        anotherGenre = genreService.create(GenreFactory.createGenre("Fiction"));
        bookLocation = BookLocationFactory.createBookLocation(book.getShelfNumber(), genre.getGenreId());
    }

    @AfterAll
    void breakDown() {
        bookService.delete(book.getBookId());
        genreService.delete(genre.getGenreId());
        genreService.delete(anotherGenre.getGenreId());
    }

    @Test
    void a_create()
    {
        BookLocation created = service.create(bookLocation);
        assertEquals(created.getGenreId(), bookLocation.getGenreId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read()
    {
        BookLocation read = service.read(bookLocation.getBookLocationId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Disabled
    void c_update()
    {
        BookLocation old = service.read(bookLocation.getBookLocationId());
        BookLocation updated = new BookLocation.Builder().copy(old).setGenreId(anotherGenre.getGenreId()).build();
        assertEquals(updated, service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete()
    {
        boolean success = service.delete(bookLocation.getBookLocationId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void d_getAll()
    {
        System.out.println("Showing all: ");
        System.out.println(service.getAll());
    }
}//** End of BookLocationServiceTest **
