package za.ac.cput.factory;

/**
 * bookLocationFactory.java
 * This code represents the BookLocationFactory.
 * @author: Melven Johannes Booysen (219201277)
 * Date: 10 June 2021
 */

//private String shelfLocation, genreId;
import za.ac.cput.entity.BookLocation;
import za.ac.cput.util.GenericHelper;

public class BookLocationFactory
{
<<<<<<< HEAD
    public static BookLocation createBookLocation (String shelfLocation, String genreId)
    {
        genreId = GenericHelper.generateId();
        shelfLocation = GenericHelper.generateId();
=======
    public static BookLocation createBookLocation ()
    {
        String genreId = GenericHelper.generateId();
        String shelfLocation = GenericHelper.generateId();
>>>>>>> 5f71e25dfbc24a5a533788550a294bb02db12b1c

        //creating instance
        BookLocation bookLocation = new BookLocation.Builder()
                .setGenreId(genreId)
                .setShelfLocation(shelfLocation)
                .build();

        return bookLocation;
    }

}//*** End of class
