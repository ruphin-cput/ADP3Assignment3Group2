package za.ac.cput.entity;
import javax.persistence.*;

/*
 * Genre.java
 * This code represents an entity using the builder pattern
 * @author Plamedie Bitota Bukasa (219260532)
 * Date: 10th June 2021
 */
@Entity
public class BookGenre
{
    @Id
    private String bookGenreId;
    private String genreId;
    private String bookId;

    @OneToOne
    private Genre genre;

    @OneToOne
    private Book book;

    private BookGenre( Builder builder)
    {
        this.bookGenreId= builder.bookGenreId;
        this.genreId=builder.genreId;
        this.bookId=builder.bookId;
    }

    public BookGenre() {

    }

    @Override
    public String toString() {
        return "BookGenre{" +
                "bookGenreId='" + bookGenreId + '\'' +
                ", genreId='" + genreId + '\'' +
                ", bookId='" + bookId + '\'' +
                '}';
    }

    public String getBookGenreId()
    {
        return bookGenreId;
    }

    public String getGenreId()
    {
        return genreId;
    }

    public String getBookId()
    {
        return bookId;
    }

    public static class Builder
    {
        private String bookGenreId,genreId,bookId;

        public BookGenre.Builder setBookGenreId(String bookGenreId)
        {
            this.bookGenreId = bookGenreId;
            return this;
        }

        public BookGenre.Builder setGenreId(String genreId) {
            this.genreId =genreId;
            return this;
        }
        public BookGenre.Builder setBookId(String bookId) {
            this.bookId =bookId;
            return this;
        }
        public BookGenre build()
        {
            return new BookGenre(this);
        }
        public BookGenre.Builder copy (BookGenre bookGenre)
        {
            this.bookGenreId=bookGenre.bookGenreId;
            this.genreId=bookGenre.genreId;
            this.bookId=bookGenre.bookId;
            return this;
        }

    }
}
