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
import za.ac.cput.entity.Author;
import za.ac.cput.factory.AuthorFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class) //If you wanted your methods to run in a specific order than you will use TestMethodOrder. That is why we indicated that the test cases are going to ru alphabetically
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //You can use this to specify which ever port you want to use and this enables that

class AuthorControllerTest
{
    private static Author author = AuthorFactory.createAuthor("Nelson", "Mandela", "Nelson Mandela, " +
            "in full Nelson Rolihlahla Mandela, byname Madiba, (born July 18, 1918, Mvezo, South Africa—died December 5, " +
            "2013, Johannesburg), Black nationalist and the first Black president of South Africa (1994–99). His negotiations " +
            "in the early 1990s with South African Pres."); //this is a author object and includes examples which will be used in the testing phase
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/author"; //this is a const and it should be in capital letters. This is the entry point into my author application. So we specify the BASE_URL.

    @Test
    void a_create()  //This is the individual parts that I am going to test.
    {
        String url = BASE_URL + "/create";
        ResponseEntity<Author> postResponse = restTemplate.postForEntity(url, author, Author.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertEquals(postResponse.getStatusCode().HttpStatus.OR
        author = postResponse.getBody();
        System.out.println("Saved data: " + author);
        assertEquals(author.getAuthorId(), postResponse.getBody().getAuthorId());
    }

    @Test
    void b_read()
    {
        String url = BASE_URL + "/read/" + author.getAuthorId();
        System.out.println("URL: " + url);
        ResponseEntity<Author> response = restTemplate.getForEntity(url, Author.class);
        assertEquals(author.getAuthorId(), response.getBody().getAuthorId());  //Checking if the author id is the same as the body and id
    }

    @Test
    void c_update()
    {
        Author updated = new Author.Builder().copy(author).setName("Rolihlahla").build();  //creating a new object & copying the author and testing it with a new name update
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Author> response = restTemplate.postForEntity(url, updated, Author.class); //this is to update the object
        assertNotNull(response.getBody());  // Checking if it is updated by return null (meaning it failed) & return the name (meaning it passed)
    }

    @Test
    void e_delete()
    {
        String url = BASE_URL + "/delete/" + author.getAuthorId(); //using the url and passing through the id I would like to delete
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

   /* @Test
    void authorWithA() // this is just testing the extra method added to get author with the name that starts with A.
    {
        String url = BASE_URL + "/getAuthorWithA";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All:");
        System.out.println(response);
        System.out.println(response.getBody());
    }*/
}