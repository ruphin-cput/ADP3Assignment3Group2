package za.ac.cput.controller.impl;

/*  BookController.java
    Book Controller
    Author: Taahir Boltman(218022972)
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Book;
import za.ac.cput.factory.BookFac;
import za.ac.cput.service.impl.BookService;

import java.util.Set;

@RestController
@RequestMapping("/Book")
public class BookContoller {
    @Autowired
    private BookService bookService;

    //@RequestMapping(value = "/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public Book create(@RequestBody Book book){
        book = BookFac.createBook(book.getShelfNumber(), book.getAuthorName(), book.getName(), book.getDesc(), book.getKeywords());
        return bookService.create(book);
    }

    @GetMapping("/read/{id}")
    public Book read(@PathVariable String bookId) {
        return bookService.read(bookId);
    }

    @PutMapping("/update")
    public Book update(@RequestBody Book book){
        return bookService.update(book);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String bookId){
        return bookService.delete(bookId);
    }

    @GetMapping("/getall")
    public Set<Book> getAll(){
        return bookService.getAll();
    }

}
