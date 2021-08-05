package za.ac.cput.Service.impl;

import za.ac.cput.Entity.Book;
import za.ac.cput.Repository.BookRepository;

import java.util.*;

public class BookService implements IBookService{
    private static BookService service = null;
    private BookRepository repository = null;

    private BookService(){ this.repository = BookRepository.getRepository();}

    public static BookService getService() {
        if (service == null) {
            service = new BookService();
        }
        return service;
    }

    @Override
    public Book create(Book book) {
        return this.repository.Create(book);
    }

    @Override
    public Book read(String s) {
        return this.repository.Read(s);
    }

    @Override
    public Book update(Book book) {
        return this.repository.Update(book);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.Delete(s);
    }

    @Override
    public Set<Book> getAll() {
        return this.repository.getAll();
    }
}
