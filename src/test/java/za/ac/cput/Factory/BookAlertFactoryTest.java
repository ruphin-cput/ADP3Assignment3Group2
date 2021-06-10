package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.BookAlert;

import static org.junit.jupiter.api.Assertions.*;

/*
    Author: Ruphin Bolonda
    Student Number: 218321392
    Description: BookAlertFactoryTest class
 */

class BookAlertFactoryTest {
    @Test
    public void testCreateBookAlert(){
        BookAlert bookAlert = BookAlertFactory.createBookAlert("Vortex","Book not returned",
                                                        true);

        System.out.println(bookAlert);
        assertNotNull(bookAlert);

    }
}