/**  GenreService.java
 Book Genre Service Test
 Author: Plamedie Bitota 219260532
 Date: 17th October 2021
 */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.BookGenre;
import za.ac.cput.factory.BookGenreFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookGenreServiceTest {

        @Autowired
        private BookGenreService service;

        private static BookGenre bookGenre1 = BookGenreFactory.createBookGenre();
        private static BookGenre bookGenre2 = BookGenreFactory.createBookGenre();

        @Test
        void a_create(){
            BookGenre created = service.create(bookGenre1);
            assertEquals(created.getBookGenreId(), bookGenre1.getBookGenreId());
            System.out.println("Created: " + created);
        }
        @Test
        void b_read(){
            BookGenre read = service.read("2b17a89a-e6db-4d34-b7ac-0846a2193379");
            assertNotNull(read);
            System.out.println("Read: " + read);
        }

        @Test
        void c_update(){
            BookGenre old = service.read("2b17a89a-e6db-4d34-b7ac-0846a2193379");
            BookGenre updated = new BookGenre.Builder().copy(old).setGenreId("251b487a-7b9f-42be-a7dc-3672db4ede93").build();
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