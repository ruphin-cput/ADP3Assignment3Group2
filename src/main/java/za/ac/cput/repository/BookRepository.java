package za.ac.cput.repository;

import za.ac.cput.entity.Book;
import java.util.*;

public class BookRepository implements IBookRepository{
    private static BookRepository repository = null;
    private Set<Book> bookDB = null;

    private BookRepository(){
        bookDB = new HashSet<Book>();
    }

    public static BookRepository getRepository(){
        if (repository == null) {
            repository = new BookRepository();
        }
        return repository;
    }

    @Override
    public Set<Book> getAll() {
        return bookDB;
    }

    @Override
    public Book create(Book book) {
        boolean success = bookDB.add(book);
        if(!success)
            return null;
        return book;
    }

    @Override
    public Book read(String bookId) {
        for(Book b: bookDB)
        {
            if(b.getBookId().equals(bookId)){
                return b;
            }
        }
        return null;
    }

    @Override
    public Book update(Book book) {
        Book oldBook = read(book.getBookId());
        if(oldBook != null) {
            bookDB.remove(oldBook);
            bookDB.add(book);
            return book;
    }
        return book;

    }


    @Override
    public boolean delete(String bookId) {
        Book bookToDelete = read(bookId);
        if(bookToDelete == null)
        return false;
        bookDB.remove(bookToDelete);
        return true;
    }
}
