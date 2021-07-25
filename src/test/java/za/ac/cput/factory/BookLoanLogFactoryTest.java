package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.BookLoanLog;

import static org.junit.jupiter.api.Assertions.*;

/*
    Author: Ruphin Bolonda
    Student Number: 218321392
    Description: BookLoanLogFactoryTest class
 */

class BookLoanLogFactoryTest {
    @Test
    public void createBookLoanLog(){
        BookLoanLog bookLoanLog = BookLoanLogFactory.createBookLoanLog("11/06/2021",
                                                            "13/06/2021",false);
        System.out.println(bookLoanLog);
        assertNotNull(bookLoanLog);
    }
}