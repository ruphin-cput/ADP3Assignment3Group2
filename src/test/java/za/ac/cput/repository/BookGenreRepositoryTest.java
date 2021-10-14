package za.ac.cput.repository;

/**
 * GenreRepositoryTest.java
 * @author Plamedie Bitota Bukasa (219260532)
 * Genre Repository Implementation
 * Date: 28th July 2021
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.factory.BookGenreFactory;
import za.ac.cput.entity.BookGenre;

import static org.junit.jupiter.api.Assertions.*;

    @TestMethodOrder(MethodOrderer.MethodName.class)

    class BookGenreRepositoryTest
    {
        private static BookGenreRepository repository = BookGenreRepository.getRepository();
        private static BookGenre bookGenre=BookGenreFactory.createBookGenre();


        @Test

        void c_create()
        {
            BookGenre created = repository.create(bookGenre);
            assertEquals(created.getBookGenreId(),bookGenre.getBookGenreId());
            System.out.println("Created: " + created);

        }

        @Test
        void d_read()
        {
            BookGenre read = repository.read(bookGenre.getBookGenreId());
            assertNotNull(read);
            System.out.println("Read: " + read);
        }

        @Test
        void e_update()
        {
            BookGenre updated = new BookGenre.Builder().copy(bookGenre).setBookGenreId("12356789").build();
            assertEquals(updated,repository.update(updated));
            System.out.println("Updated: " + updated);
        }

        @Test
        void f_delete()
        {
            boolean success = repository.delete(bookGenre.getBookGenreId());
            assertTrue(success);
            System.out.println("Deleted: " + success);
        }
    }