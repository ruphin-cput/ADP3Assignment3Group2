package za.ac.cput.entity;


import javax.persistence.*;

/**
 * bookLocation.java
 * This code represents an entity using the builder pattern
 * @author: Melven Johannes Booysen (219201277)
 * Date: 10 June 2021
 */

@Entity
@IdClass(BookLocationId.class) //do I need this or does book class need it.
public class BookLocation
{
    @EmbeddedId
    private BookLocationId bookLocationId;
    @Id
    @Column(name="bl_shelf_location", insertable = false, updatable = false)
    private String shelfLocation;
    @Id
    @Column(name="bl_genre_id", insertable = false, updatable = false)
    private String genreId;

    @OneToOne
    @JoinColumn(name="genreId", insertable = false, updatable = false)
    private Genre genre;

    @OneToOne
    @JoinColumn(name="shelfNumber", insertable = false, updatable = false)
    private Book book;

    private BookLocation(Builder builder)
    {
        this.bookLocationId = new BookLocationId();
        this.bookLocationId.setShelfLocation(builder.shelfLocation);
        this.bookLocationId.setGenreId(builder.genreId);
        this.genreId = builder.genreId;
        this.shelfLocation = builder.shelfLocation;
    }

    //Default Constructor
    public BookLocation() {

    }

    //Getters
    public BookLocationId getBookLocationId()
    {
        return bookLocationId;
    }

    public String getShelfLocation()
    {
        return bookLocationId.getShelfLocation();
    }

    public String getGenreId()
    {
        return bookLocationId.getGenreId();
    }//End of getters


    public static class Builder
    {
        private String shelfLocation, genreId;
        private BookLocationId bookLocationId;

        //Setters
        public Builder setShelfLocation(String shelfLocation)
        {
            this.shelfLocation = shelfLocation;
            return this;
        }

        public Builder setGenreId(String genreId)
        {
            this.genreId = genreId;
            return this;
        }//End of setters

        public Builder setBookLocationId(BookLocationId bookLocationId) {
            this.bookLocationId = bookLocationId;
            return this;
        }

        public BookLocation build()
        {
            return new BookLocation(this);
        }

        public Builder copy(BookLocation bookLocation)
        {
            this.shelfLocation = bookLocation.getBookLocationId().getShelfLocation();
            this.genreId = bookLocation.getBookLocationId().getGenreId();

            return this;
        }
    }//*** End of inner class ***

    @Override
    public String toString()
    {
        return "BookLocation{" +
                "shelfLocation='" + bookLocationId.getShelfLocation() + '\'' +
                ", genreId='" + bookLocationId.getGenreId() + '\'' +
                '}';
    }

}//*** End of outer class ***