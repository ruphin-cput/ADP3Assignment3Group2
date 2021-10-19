package za.ac.cput.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.BookGenre;
import za.ac.cput.factory.BookGenreFactory;
import za.ac.cput.service.impl.BookGenreService;


import java.util.Set;

    //This package "Controller" - is used to expose our services. (e.g. display)
    @RestController
    @RequestMapping("/bookGenre")
    public class BookGenreController
    {
        @Autowired
        private BookGenreService bookGenreService;


        @PostMapping("/create")
        public BookGenre create(@RequestBody BookGenre bookGenre)
        {
            bookGenre = BookGenreFactory.createBookGenre();
            return bookGenreService.create(bookGenre);
        }

        @GetMapping("/read/{bookGenreId}")
        public BookGenre read(@PathVariable String bookGenreId)
        {
            return bookGenreService.read(bookGenreId);
        }

        @PostMapping("/update")
        public BookGenre update(@RequestBody BookGenre bookGenre)
        {
            return bookGenreService.update(bookGenre);
        }

        @PostMapping("/delete/{bookGenreId}")
        public boolean delete(@PathVariable String bookGenreId)
        {
            return bookGenreService.delete(bookGenreId);
        }

        @GetMapping("/getall")
        public Set<BookGenre> getAll()
        {
            return bookGenreService.getAll();
        }



}
