package za.ac.cput.factory;

/**
 * bookLocation.java
 * Below is a conduction of the BookLocationFactory test case.
 * @author: Melven Johannes Booysen (219201277)
 * Date: 10 June 2021
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.BookLocation;

import static org.junit.jupiter.api.Assertions.*;

class BookLocationFactoryTest
{
    @Test
    public void createBookLocation()
    {
        BookLocation bookLocation = BookLocationFactory.createBookLocation("4", " ");//++++ need to get the id of the two id tables
        System.out.println(bookLocation);
        assertEquals(bookLocation);
    }

    private void assertEquals(BookLocation bookLocation) {
    }

    private BookLocation book1;
    private BookLocation book2;
    private BookLocation book3;

    @BeforeEach
    void setUp()
    {
        book1 = new BookLocation.Builder().build(); //getting author object.
        book2 = new BookLocation.Builder().build();
        book3 = book1;
    }

    @Test
    void testIdentity()
    {
        assertSame(book1, book3); //"assertSame" Expecting a true value, but assertNotSame is expected to fail.
    }

    @Test
    void testEquality()
    {
        //fail("The test case is a prototype");
        assertEquals(book1, book3);
    }

    private void assertEquals(BookLocation book1, BookLocation book3) {
    }

    @Test
    void testFail()
    {
        fail("Failed");
    }

    @Test
    @Timeout(4)
    void testTimeout()
    {
        System.out.println("HI");
    }

    @Test
    @Disabled
    void testDisabling()
    {
        fail("Shouldn't fail");
    }

}//*** End of test class ***