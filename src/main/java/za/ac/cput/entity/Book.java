package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/*  Book.java
    Book entity
    Author: Taahir Boltman(218022972)
    Date: 10 June 2021
 */
@Entity
public class Book implements Serializable {
    @Id
    private String bookId;
    private String shelfNumber, authorName, bookName, bookDescription, keywords;

    private Book(){}

    private Book(bookBuilder bookBuilder) {
        this.bookId= bookBuilder.bookId;
        this.shelfNumber= bookBuilder.shelfNumber;
        this.authorName= bookBuilder.authorName;
        this.bookName= bookBuilder.bookName;
        this.bookDescription= bookBuilder.bookDescription;
        this.keywords= bookBuilder.keywords;
    }

    public String getBookId() {
        return bookId;
    }

    public String getShelfNumber() {
        return shelfNumber;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getbookName() {
        return bookName;
    }

    public String getbookDescription() {
        return bookDescription;
    }

    public String getKeywords() {
        return keywords;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", shelfNumber='" + shelfNumber + '\'' +
                ", authorName='" + authorName + '\'' +
                ", name='" + bookName + '\'' +
                ", desc='" + bookDescription + '\'' +
                ", keywords=" + keywords +
                '}';
    }

    public static class bookBuilder{
        private String bookId, shelfNumber, authorName, bookName, bookDescription, keywords;


        public bookBuilder setBookId(String bookId) {
            this.bookId = bookId;
            return this;
        }

        public bookBuilder setShelfNumber(String shelfNumber) {
            this.shelfNumber = shelfNumber;
            return this;
        }

        public bookBuilder setAuthorName(String authorName) {
            this.authorName = authorName;
            return this;
        }

        public bookBuilder setbookName(String name) {
            this.bookName = bookName;
            return this;
        }

        public bookBuilder setbookDescription(String desc) {
            this.bookDescription = bookDescription;
            return this;
        }

        public bookBuilder setKeywords(String keywords) {
            this.keywords = keywords;
            return this;
        }

        public Book build() {
            return new Book(this);
        }

        public bookBuilder copy(Book book) {
            this.bookId= book.bookId;
            this.shelfNumber= book.shelfNumber;
            this.authorName= book.authorName;
            this.bookName= book.bookName;
            this.bookDescription= book.bookDescription;
            this.keywords= book.keywords;
            return this;
        }
    }


}

