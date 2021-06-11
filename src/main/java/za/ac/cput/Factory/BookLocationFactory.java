package za.ac.cput.Factory;

/**
 * bookLocationFactory.java
 * This code represents the BookLocationFactory.
 * @author: Melven Johannes Booysen (219201277)
 * Date: 10 June 2021
 */

//private String shelfLocation, genreId;
import za.ac.cput.Entity.BookLocation;
import za.ac.cput.Util.GenericHelper;

public class BookLocationFactory
{
    public static BookLocation createBookLocation ()
    {
        String genreId = GenericHelper.generateId();
        String shelfLocation = GenericHelper.generateId();

        //creating instance
        BookLocation bookLocation = new BookLocation.Builder()
                .setGenreId(genreId)
                .setShelfLocation(shelfLocation)
                .build();

        return bookLocation;
    }

}//*** End of class
