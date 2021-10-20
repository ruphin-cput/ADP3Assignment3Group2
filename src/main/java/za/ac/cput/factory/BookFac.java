package za.ac.cput.factory;

/*  BookFac.java
    Book entity factory
    Author: Taahir Boltman(218022972)
    Date: 10 June 2021
 */

import za.ac.cput.entity.Book;
import za.ac.cput.util.GenericHelper;

public class BookFac {
    public static Book createBook(String shelfNumber, String authorname, String bookName,
                                  String bookDescription, String keywords){

        if(shelfNumber.isEmpty() || authorname.isEmpty() || bookName.isEmpty() || bookDescription.isEmpty() || keywords.isEmpty()){
            return null;
        }

        String bookId = GenericHelper.generateId();

        Book book = new Book.bookBuilder()
              .setBookId(bookId)
                .setShelfNumber(shelfNumber)
                .setAuthorName(authorname)
                .setbookName(bookName)
                .setbookDescription(bookDescription)
                .setKeywords(keywords)
                .build();

        return book;


    }
}

