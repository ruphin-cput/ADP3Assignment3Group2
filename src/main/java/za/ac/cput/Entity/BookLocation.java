package za.ac.cput.Entity;

/**
 * bookLocation.java
 * This code represents an entity using the builder pattern
 * @author: Melven Johannes Booysen (219201277)
 * Date: 10 June 2021
 */

public class BookLocation
{
    private String shelfLocation, genreId;

    private BookLocation(Builder builder)
    {
        this.shelfLocation = builder.shelfLocation;
        this.genreId = builder.genreId;
    }

    public static class Builder
    {
        private String shelfLocation, genreId;

        public Builder setShelfLocation(String shelfLocation)
        {
            this.shelfLocation = shelfLocation;
            return this;
        }

        public Builder setGenreId(String genreId)
        {
            this.genreId = genreId;
            return this;
        }

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
