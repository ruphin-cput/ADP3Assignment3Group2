package za.ac.cput.service.impl;
/*  BookServiceTest.java
    Book Service Test
    Author: Taahir Boltman(218022972)
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Book;
import za.ac.cput.factory.BookFac;
import za.ac.cput.service.impl.BookService;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class BookServiceTest {
    private static BookService service;
    private static Book book = BookFac.createBook("4","T.Boltman","The Moon and The Sun","A ball of a fire and a rock","Sun,Moon,");

    @Test
    void create() {
        Book created = service.create(book);
        assertEquals(created.getBookId(), book.getBookId());
        System.out.println("Created: " + created);
    }

    @Test
    void read() {
        Book read = service.read(book.getBookId());
        assertNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update(){
        Book old = service.read(book.getBookId());
        Book updated = new Book.bookBuilder().copy(book).setDesc("Fire ball, Rock ball").build();
        assertEquals(updated,service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete(){
        boolean success = service.delete(book.getBookId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void getAll(){
        System.out.println("Showing all: ");
        System.out.println(service.getAll());
    }



}
