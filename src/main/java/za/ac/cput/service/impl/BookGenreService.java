/**  GenreService.java
 Book Genre Service implementation
 Author: Plamedie Bitota 219260532
 Date: 1st August 2021
 */
package za.ac.cput.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.BookGenre;
import za.ac.cput.repository.BookGenreRepository;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookGenreService implements IBookGenreService {

    private static BookGenreService service=null;
        @Autowired
        private BookGenreRepository repository;

        @Override
        public BookGenre create(BookGenre bookgenre) {  return this.repository.save(bookgenre); }

        @Override
        public BookGenre read(String bookGenreId) {
            return this.repository
                    .findById(bookGenreId)
                    .orElse(null);
        }

        @Override
        public BookGenre update(BookGenre bookgenre) {
            if(this.repository.existsById(bookgenre.getBookGenreId()))
                return this.repository.save(bookgenre);
            return null;
        }

        @Override
        public boolean delete(String bookGenreId) {
            this.repository.deleteById(bookGenreId);
            if(this.repository.existsById(bookGenreId))
                return false;
            else
                return true;
        }

        @Override
        public Set<BookGenre> getAll() {
            return this.repository
                    .findAll()
                    .stream()
                    .collect(Collectors.toSet());
        }
    }
