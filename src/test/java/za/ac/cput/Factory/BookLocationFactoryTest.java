package za.ac.cput.Factory;

/**
 * bookLocation.java
 * Below is a conduction of the BookLocationFactory test case.
 * @author: Melven Johannes Booysen (219201277)
 * Date: 10 June 2021
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.BookLocation;

import static org.junit.jupiter.api.Assertions.*;

class BookLocationFactoryTest
{
    @Test
    public void createBookLocation()
    {
        BookLocation bookLocation = BookLocationFactory.createBookLocation();
        System.out.println(bookLocation);
        // assert (need to add assert method sortable for here)
    }

}//*** End of test class ***