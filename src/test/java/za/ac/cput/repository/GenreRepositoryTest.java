package za.ac.cput.repository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.BookGenre;
import za.ac.cput.entity.Genre;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.factory.BookGenreFactory;
import za.ac.cput.factory.GenreFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class GenreRepositoryTest
{
    private static GenreRepository repository = GenreRepository.getRepository();
    private static Genre genre= GenreFactory.createGenre("Romance");
    @Test

    void a_create()
    {
        Genre created = repository.create(genre);
        assertEquals(created.getGenreId(),genre.getGenreId());
        System.out.println("Created: " + created);

    }

    @Test
    void b_read()
    {
        Genre read = repository.read(genre.getGenreId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update()
    {
        Genre updated = new Genre.Builder().copy(genre).setName("Action").build();
        assertEquals(updated,repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_delete()
    {
        boolean success = repository.delete(genre.getGenreId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

}