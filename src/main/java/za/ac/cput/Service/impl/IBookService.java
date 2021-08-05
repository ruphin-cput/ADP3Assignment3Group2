package za.ac.cput.Service.impl;

import za.ac.cput.Entity.Book;
import za.ac.cput.Service.IService;

import java.util.*;

public interface IBookService extends IService<Book,String> {
    public Set<Book> getAll();
}
