package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.BookLocation;
import za.ac.cput.repository.BookLocationRepository;

import java.util.Set;
@Service  //NB add the @Service to avoid errors
public class BookLocationService implements IBookLocationService
{
    private static BookLocationService service = null;
    private BookLocationRepository repository = null;

    private BookLocationService() {this.repository = BookLocationRepository.getRepository();}

    public static BookLocationService getService()
    {
        if(service == null)
        {
            service = new BookLocationService();
        }
        return service;
    }

    @Override
    public BookLocation create(BookLocation bookLocation) {
        return this.repository.create(bookLocation);
    }

    @Override
    public BookLocation read(String shelfLocation) {  //What does one do if it is a composite key, than what do we put in the brackets
        return this.repository.read(shelfLocation);
    }

    @Override
    public BookLocation update(BookLocation bookLocation) {
        return this.repository.update(bookLocation);
    }

    @Override
    public boolean delete(String shelfLocation) {
        return this.repository.delete(shelfLocation);
    }

    @Override
    public Set<BookLocation> getAll() {
        return this.repository.getAll();
    }
}

