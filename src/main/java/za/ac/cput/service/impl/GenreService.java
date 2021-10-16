package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.service.impl.IGenreService;
import za.ac.cput.entity.Genre;
import za.ac.cput.repository.GenreRepository;

import java.util.Set;

/**  GenreService.java
 Genre Service implementation
 Author: Plamedie Bitota 219260532
 Date: 1st August 2021
 */
@Service
public class GenreService implements IGenreService {
    private static za.ac.cput.service.impl.GenreService service = null;
    private GenreRepository repository = null;


    private GenreService(){ this.repository = GenreRepository.getRepository();}

    public static za.ac.cput.service.impl.GenreService getService(){
        if(service == null){
            service = new za.ac.cput.service.impl.GenreService();
        }
        return service;
    }

    @Override
    public Genre create(Genre genre) { return this.repository.create(genre);  }

    @Override
    public Genre read(String genreId) { return this.repository.read(genreId); }

    @Override
    public Genre update(Genre genre ) {  return this.repository.update(genre);  }

    @Override
    public boolean delete(String genreId) {  return this.repository.delete(genreId); }

    @Override
    public Set<Genre> getAll() {   return this.repository.getAll();  }
}
