package za.ac.cput.ServiceTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Book;
import za.ac.cput.Factory.BookFac;
import za.ac.cput.Service.impl.BookService;

import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest {
    private static BookService service = BookService.getService();
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
