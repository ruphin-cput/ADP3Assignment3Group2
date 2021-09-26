package za.ac.cput.repository;

import za.ac.cput.entity.BookLocation;

import java.util.HashSet;
import java.util.Set;

public class BookLocationRepository implements IBookLocationRepository
{
    private static BookLocationRepository repository = null;
    private Set<BookLocation> bookLocationDB = null;

    private BookLocationRepository() { bookLocationDB = new HashSet<BookLocation>();}

    public static BookLocationRepository getRepository()
    {
        if(repository == null)
        {
            repository = new BookLocationRepository();
        }
        return repository;
    }

    @Override
    public BookLocation create(BookLocation bookLocation)
    {
        boolean success = bookLocationDB.add(bookLocation); //Need to create a add method in bookLocation entity
        if(!success)
            return null;
        return bookLocation;
    }

    @Override
    public BookLocation read(String shelfLocation)
    {
        BookLocation bookLocation = bookLocationDB.stream()
                .filter(e -> e.getShelfLocation().equals(shelfLocation))  //Need to resolve issue
                .findAny()
                .orElse(null);
        return bookLocation;
    }

    @Override
    public BookLocation update(BookLocation bookLocation)
    {
        BookLocation oldBookLocation = read(bookLocation.getShelfLocation());
        if(oldBookLocation != null)
        {
            bookLocationDB.remove(oldBookLocation);
            bookLocationDB.add(bookLocation);
            return bookLocation;
        }
        return null;
    }

    @Override
    public boolean delete(String shelfLocation)
    {
        BookLocation bookLocationToDelete = read(shelfLocation);
        if(bookLocationToDelete == null)
            return false;
        bookLocationDB.remove(bookLocationToDelete);
        return true;
    }

    @Override
    public Set<BookLocation> getAll() {
        return bookLocationDB;
    }
}

