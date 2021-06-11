package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Genre;

import static org.junit.jupiter.api.Assertions.*;

class GenreFactoryTest
{
    @Test
    public void  createGenre()
    {
        Genre genre=GenreFactory.createGenre("Romance");
        System.out.println(genre);
    }
}