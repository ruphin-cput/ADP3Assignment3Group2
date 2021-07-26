package za.ac.cput.Repository;

import za.ac.cput.Entity.Book;

import java.util.*;

public interface IBookRepository extends IRepository<Book, String>{
    public Set<Book> getAll();
}
