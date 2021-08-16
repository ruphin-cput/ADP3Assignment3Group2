package za.ac.cput.service.impl;

import za.ac.cput.entity.Book;
import za.ac.cput.service.IService;

import java.util.*;

public interface IBookService extends IService<Book,String> {
    public Set<Book> getAll();
}
