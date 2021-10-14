package za.ac.cput.repository;

/**
 * GenreRepository.java
 * @author Plamedie Bitota Bukasa (219260532)
 * Genre Repository Implementation
 * Date: 28th July 2021
 */

import za.ac.cput.entity.Genre;
import java.util.HashSet;
import java.util.Set;

public class GenreRepository implements IGenreRepository
{
    private static GenreRepository repository = null;
    private Set<Genre> genreDB = null;

    private GenreRepository(){
        genreDB = new HashSet<Genre>();
    }

    public static GenreRepository getRepository(){
        if (repository == null) {
            repository = new GenreRepository();
        }
        return repository;
    }

    @Override

    public Genre create(Genre genre)
    {
        boolean success = genreDB.add(genre);
        if(!success)
            return null;
        return genre;
    }
    @Override
    public Genre read (String genreId)
    {
        Genre genre=null;
        for (Genre g: genreDB)
        {
            if (g.getGenreId().equalsIgnoreCase((genreId)))
            {
               return g;

            }

        }
        return null;
    }
    @Override
    public Genre update  (Genre genre)
    {
        Genre oldGenre=read(genre.getGenreId());
        if(oldGenre!=null)
        {
            genreDB.remove(oldGenre);
            genreDB.add(genre);
            return genre;
        }
        return genre;
    }

    @Override
    public boolean delete (String genreId)
    {
        Genre genreToDelete = read(genreId);
        if(genreToDelete == null)
            return false;
        genreDB.remove(genreToDelete);
        return true;
    }

    @Override
    public Set<Genre> getAll() {
        return null;
    }


}
