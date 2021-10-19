package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Author;
import za.ac.cput.entity.BookLocation;
import za.ac.cput.repository.BookLocationRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service  //NB add the @Service to avoid errors
public class BookLocationService implements IBookLocationService
{
    private static BookLocationService service = null;

    @Autowired
    private BookLocationRepository repository;

    @Override
    public BookLocation create(BookLocation bookLocation) {
        return this.repository.save(bookLocation);
    }

    @Override
    public BookLocation read(String shelfLocation) {
        return this.repository.findById(shelfLocation).orElse(null);
    } //What does one do if it is a composite key, than what do we put in the brackets

    @Override
    public BookLocation update(BookLocation bookLocation) {
        if(this.repository.existsById(bookLocation.getShelfLocation()))
            return this.repository.save(bookLocation);
        return null;
    }

    @Override
    public boolean delete(String shelfLocation) {
        this.repository.deleteById(shelfLocation);
        if (this.repository.existsById(shelfLocation))
            return false;
        else
            return true;
    }

    @Override
    public Set<BookLocation> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

}

