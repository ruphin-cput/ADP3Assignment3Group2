package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.BookGenre;
import za.ac.cput.Entity.Genre;

import static org.junit.jupiter.api.Assertions.*;

class BookGenreFactoryTest { @Test
public void  createGenre()
{
    BookGenre bookGenre=BookGenreFactory.createBookGenre();
    System.out.println(bookGenre);
}

}