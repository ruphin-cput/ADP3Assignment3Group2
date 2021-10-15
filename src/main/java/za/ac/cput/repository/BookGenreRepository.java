/**
 * BookGenreRepository.java
 * @author Plamedie Bitota Bukasa (219260532)
 * Genre Repository Implementation
 * Date: 28th July 2021
 * */
 package za.ac.cput.repository;
import za.ac.cput.entity.BookGenre;
import java.util.HashSet;
import java.util.Set;

public class BookGenreRepository implements IBookGenreRepository
{
    private static BookGenreRepository repository = null;
    private Set<BookGenre> bookGenreDB = null;

    private BookGenreRepository()
    {
        bookGenreDB = new HashSet<BookGenre>();
    }

    public static BookGenreRepository getRepository(){
        if (repository == null)
        {
            repository = new BookGenreRepository();
        }
        return repository;
    }

    @Override

    public BookGenre create(BookGenre bookgenre)
    {

        boolean success = bookGenreDB.add(bookgenre);
        if(!success)
            return null;
        return bookgenre;
    }
    @Override
    public BookGenre read (String bookGenreID)
    {
        BookGenre bookGenre=null;
        for (BookGenre g: bookGenreDB)
        {
            if (g.getBookGenreId().equalsIgnoreCase((bookGenreID)))
            {
                return g;
            }

        }
        return null;
    }
    @Override
    public BookGenre update  (BookGenre bookGenre)
    {
        BookGenre oldBookGenre=read(bookGenre.getBookGenreId());
        if(oldBookGenre!=null)
        {
            bookGenreDB.remove(oldBookGenre);
            bookGenreDB.add(bookGenre);
            return bookGenre;
        }
        return bookGenre;
    }

    @Override
    public boolean delete (String bookGenreId)
    {
        BookGenre bookGenreToDelete = read(bookGenreId);
        if(bookGenreToDelete == null)
            return false;
        bookGenreDB.remove(bookGenreToDelete);
        return true;
    }

    @Override
    public Set<BookGenre> getAll()
    {
        return null;
    }


}

