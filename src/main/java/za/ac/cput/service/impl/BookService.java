package za.ac.cput.service.impl;
/*  BookService.java
    Book Service
    Author: Taahir Boltman(218022972)
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Book;
import za.ac.cput.repository.BookRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService{
    private static BookService service = null;

    @Autowired
    private BookRepository repository;

    //private BookService(){ this.repository = BookRepository.getRepository();}

    /*public static BookService getService() {
        if (service == null) {
            service = new BookService();
        }
        return service;
    }

     */

    @Override
    public Book create(Book book) {
        return this.repository.save(book);
    }

    @Override
    public Book read(String bookId) {
        return this.repository.findById(bookId).orElse(null);
    }

    @Override
    public Book update(Book book) {
        if(this.repository.existsById(book.getBookId()))
            return this.repository.save(book);
        return null;
    }

    @Override
    public boolean delete(String bookId) {
        this.repository.deleteById(bookId);
        if (this.repository.existsById(bookId))
            return false;
        else
            return true;
    }

    @Override
    public Set<Book> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
