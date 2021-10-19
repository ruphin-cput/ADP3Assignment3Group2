package za.ac.cput.entity;


import javax.persistence.*;

/**
 * bookLocation.java
 * This code represents an entity using the builder pattern
 * @author: Melven Johannes Booysen (219201277)
 * Date: 10 June 2021
 */

@Entity
//@IdClass(Book.class) //do I need this or does book class need it.
public class BookLocation
{
    @Id
    private String shelfLocation;
    @Id
    private String genreId;
    @OneToOne
    @PrimaryKeyJoinColumn(name="shelfNumber",referencedColumnName="shelfNumber")
    private Book book;
    @OneToMany
    @PrimaryKeyJoinColumn(name="genreId",referencedColumnName="genreId")
    private Genre genre;

    private BookLocation(Builder builder)
    {
        this.shelfLocation = builder.shelfLocation;
        this.genreId = builder.genreId;
    }

    //Default Constructor
    public BookLocation() {

    }

    //Getters
    public String getShelfLocation()
    {
        return shelfLocation;
    }

    public String getGenreId()
    {
        return genreId;
    }//End of getters

    /*public boolean add(BookLocation bookLocation)
    {

    }*/

    public static class Builder
    {
        private String shelfLocation, genreId;

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

        public BookLocation build()
        {
            return new BookLocation(this);
        }

        public Builder copy(BookLocation bookLocation)
        {
            this.shelfLocation = bookLocation.shelfLocation;
            this.genreId = bookLocation.genreId;

            return this;
        }
    }//*** End of inner class ***

    @Override
    public String toString()
    {
        return "BookLocation{" +
                "shelfLocation='" + shelfLocation + '\'' +
                ", genreId='" + genreId + '\'' +
                '}';
    }

}//*** End of outer class ***