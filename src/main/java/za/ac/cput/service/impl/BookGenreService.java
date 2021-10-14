/**  GenreService.java
 Book Genre Service implementation
 Author: Plamedie Bitota 219260532
 Date: 1st August 2021
 */
package za.ac.cput.service.impl;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.BookGenre;
import za.ac.cput.repository.BookGenreRepository;

import java.util.*;
@Service
public class BookGenreService implements IBookGenreService {

    private static BookGenreService service = null;
    private BookGenreRepository repository = null;

    private BookGenreService()
    {
        this.repository = BookGenreRepository.getRepository();
    }

    public static BookGenreService getService(){
        if(service == null){
            service = new za.ac.cput.service.impl.BookGenreService();
        }
        return service;
    }

    @Override
    public BookGenre create(BookGenre bookGenre) { return this.repository.create(bookGenre);  }

    @Override
    public BookGenre read(String BookGenreId) { return this.repository.read(BookGenreId); }

    @Override
    public BookGenre update(BookGenre bookGenre ) {  return this.repository.update(bookGenre);  }

    @Override
    public boolean delete(String bookGenreId) {  return this.repository.delete(bookGenreId); }

    @Override
    public Set<BookGenre> getAll() {   return this.repository.getAll();  }
}
