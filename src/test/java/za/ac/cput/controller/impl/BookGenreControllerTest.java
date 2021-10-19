package za.ac.cput.controller.impl;
import  org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.BookGenre;
import za.ac.cput.factory.BookGenreFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class BookGenreControllerTest
{
    private static BookGenre bookGenre = BookGenreFactory.createBookGenre();
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/bookGenre";

    @Test
    void a_create()
    {
        String url = BASE_URL + "/create";
        ResponseEntity<BookGenre> postResponse = restTemplate.postForEntity(url, bookGenre, BookGenre.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        bookGenre= postResponse.getBody();
        System.out.println("BookGenre in the system  " + bookGenre);
        assertEquals(bookGenre.getBookGenreId(), postResponse.getBody().getBookGenreId());
    }

    @Test
    void b_read()
    {
        String url = BASE_URL + "/read/" + bookGenre.getBookGenreId();
        System.out.println("URL: " + url);
        ResponseEntity<BookGenre> response = restTemplate.getForEntity(url, BookGenre.class);
        assertEquals(bookGenre.getBookGenreId(), response.getBody().getBookGenreId());
    }

    @Test
    void c_update()
    {
        BookGenre updated = new BookGenre.Builder().copy(bookGenre).setBookGenreId("").build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Update: " + updated);
        ResponseEntity<BookGenre> response = restTemplate.postForEntity(url, updated, BookGenre.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete()
    {
        String url = BASE_URL + "/delete/" + bookGenre.getBookGenreId();
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