package za.ac.cput.Factory;

/**
 * authorFactory.java
 * Below is a conduction of the AuthorFactory test case
 * @author: Melven Johannes Booysen (219201277)
 * Date: 10 June 2021
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Author;

import static org.junit.jupiter.api.Assertions.*;

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
        // assert (need to add assert method sortable for here)
    }

}//*** End of test class ***