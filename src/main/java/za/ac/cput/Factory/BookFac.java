package za.ac.cput.Factory;

/*  BookFac.java
    Book entity factory
    Author: Taahir Boltman(218022972)
    Date: 10 June 2021
 */

import za.ac.cput.Entity.Book;
import za.ac.cput.Util.GenericHelper;

import java.util.ArrayList;

public class BookFac {
    public static Book createBook(String shelfNumber, String authorname, String name,
                                  String desc, String keywords){

        String bookId = GenericHelper.generateId();

        Book book = new Book.bookBuilder()
                .setBookId(bookId)
                .setShelfNumber(shelfNumber)
                .setAuthorName(authorname)
                .setName(name)
                .setDesc(desc)
                .setKeywords(keywords)
                .build();

        return book;
    }
}
