package za.ac.cput.Factory;

/**
 * authorFactory.java
 * Below is a conduction of the AuthorFactory test case
 * @author: Melven Johannes Booysen (219201277)
 * Date: 10 June 2021
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.Entity.Author;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthorFactoryTest
{
    @Test
    public void createAuthor()
    {
        Author author = AuthorFactory.createAuthor("David", "Baccarini","David is Associate Professor in Project Management at Curtin University.\n" +
                                                                                          "He commenced his career as a quantity surveyor before entering academia.\n" +
                                                                                          "He gained his Master in Project Management in 1986 from South Bank University \n" +
                                                                                          "(London), commencing his long involvement in the discipline of project management.");
        System.out.println(author);
        assertEquals(author);
    }

    private void assertEquals(Author author) {
    }

    private Author author1;
    private Author author2;
    private Author author3;

    @BeforeEach
    void setUp()
    {
        author1 = new Author.Builder().build();
        author2 = new Author.Builder().build();
        author3 = author1;
    }

    @Test
    void testIdentity()
    {
        assertSame(author1, author3); //"assertSame" Expecting a true value, but assertNotSame is expected to fail.
    }

    @Test
    void testEquality()
    {
        //fail("The test case is a prototype");
        assertEquals(author1, author3);
    }

    private void assertEquals(Author author1, Author author3) {
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