package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Genre;
import za.ac.cput.repository.GenreRepository;

import java.util.Set;
import java.util.stream.Collectors;

/**  GenreService.java
 Genre Service implementation
 Author: Plamedie Bitota 219260532
 Date: 1st August 2021
 */
@Service
public class GenreService implements IGenreService {

    private static GenreService service=null;
    @Autowired
    private GenreRepository repository;

    @Override
    public Genre create(Genre genre) {  return this.repository.save(genre); }

    @Override
    public Genre read(String GenreId) {
        return this.repository
                .findById(GenreId)
                .orElse(null);
    }

    @Override
    public Genre update(Genre genre) {
        if(this.repository.existsById(genre.getGenreId()))
            return this.repository.save(genre);
        return null;
    }

    @Override
    public boolean delete(String GenreId) {
        this.repository.deleteById(GenreId);
        if(this.repository.existsById(GenreId))
            return false;
        else
            return true;
    }

    @Override
    public Set<Genre> getAll() {
        return this.repository
                .findAll()
                .stream()
                .collect(Collectors.toSet());
    }
}