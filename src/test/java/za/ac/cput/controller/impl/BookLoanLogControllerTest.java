package za.ac.cput.controller.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.BookLoanLog;
import za.ac.cput.factory.BookLoanLogFactory;

import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class BookLoanLogControllerTest {
    static SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
    static SimpleDateFormat s2 = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
    static String date1 = "2021-09-09";
    static String date2 = "2021-09-11";
    private static BookLoanLog bookLoanLog = BookLoanLogFactory.createBookLoanLog(date1,date2,false);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/loan";

    @Test
    void a_create()  //This is the individual parts that I am going to test.
    {
        String url = BASE_URL + "/create";
        ResponseEntity<BookLoanLog> postResponse = restTemplate.postForEntity(url, bookLoanLog, BookLoanLog.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertEquals(postResponse.getStatusCode().HttpStatus.OR
        bookLoanLog = postResponse.getBody();
        System.out.println("Saved data: " + bookLoanLog);
        assertEquals(bookLoanLog.getBookLoanLogId(), postResponse.getBody().getBookLoanLogId());
    }

    @Test
    void b_read()
    {
        String url = BASE_URL + "/read/" + bookLoanLog.getBookLoanLogId();
        System.out.println("URL: " + url);
        ResponseEntity<BookLoanLog> response = restTemplate.getForEntity(url, BookLoanLog.class);
        assertEquals(bookLoanLog.getBookLoanLogId(), response.getBody().getBookLoanLogId());
    }

    @Test
    void c_update()
    {
        BookLoanLog updated = new BookLoanLog.Builder().copy(bookLoanLog).build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<BookLoanLog> response = restTemplate.postForEntity(url, updated, BookLoanLog.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete()
    {
        String url = BASE_URL + "/delete/" + bookLoanLog.getBookLoanLogId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll()
    {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}