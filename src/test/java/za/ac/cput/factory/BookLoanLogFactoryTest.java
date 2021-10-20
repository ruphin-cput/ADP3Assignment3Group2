package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.BookLoanLog;

import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/*
    Author: Ruphin Bolonda
    Student Number: 218321392
    Description: BookLoanLogFactoryTest class
 */

class BookLoanLogFactoryTest {

    private BookLoanLog bl1, bl2;
    static SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
    static SimpleDateFormat s2 = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
    static String date1 = "2021-09-09";
    static String date2 = "2021-09-09";

    @Test
    void createBookLoanLog() {
        bl1 = BookLoanLogFactory.createBookLoanLog(date1,date2,true);
        bl1 = BookLoanLogFactory.createBookLoanLog(date1,date2,true);
        System.out.println(bl1);
        System.out.println(bl2);
        assertNotNull(bl1);
    }

}