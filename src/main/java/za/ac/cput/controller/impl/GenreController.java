package za.ac.cput.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Genre;
import za.ac.cput.factory.GenreFactory;
import za.ac.cput.service.impl.GenreService;

import java.util.Set;


@RestController
@RequestMapping("/Genre")
public class GenreController
{
    @Autowired
    private GenreService GenreService;


    @PostMapping("/create")
    public Genre create(@RequestBody Genre genre)
    {
        genre = GenreFactory.createGenre(genre.getGenreId());
        return GenreService.create(genre);
    }

    @GetMapping("/read/{bookGenreId}")
    public Genre read(@PathVariable String genreId)
    {
        return GenreService.read(genreId);
    }

    @PostMapping("/update")
    public Genre update(@RequestBody Genre genre)
    {
        return GenreService.update(genre);
    }

    @PostMapping("/delete/{bookGenreId}")
    public boolean delete(@PathVariable String genreId)
    {
        return GenreService.delete(genreId);
    }

    @GetMapping("/getall")
    public Set<Genre> getAll()
    {
        return GenreService.getAll();
    }



}

