package za.ac.cput.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.entity.Book;
import za.ac.cput.entity.BookLocation;
import za.ac.cput.entity.Genre;
import za.ac.cput.factory.BookLocationFactory;
import za.ac.cput.service.impl.BookLocationService;
import za.ac.cput.service.impl.BookService;
/*
@RestController
@RequestMapping("/bookLocation")
public class BookLocationController
{
    //We do this 3 way @autowired when it is a 'bridge entity' and we trying to see if the the values are there.
    @Autowired
    private BookService bookService;

    @Autowired
    private BookLocationService bookLocationService;

    @Autowired
    private GenreService genreService; //its red because the member in charge didnt create it.

    @PostMapping("/create")
    public BookLocation create(@RequestBody BookLocation bookLocation) //We checking if bookLocation is going to add the two parameters, which is genreId & shelfLocation
    {
        boolean bookExist = false;
        boolean genreExist = false;

        Book book = bookService.read(BookLocation.getShelfNumber()); //checking if shelfNumber exist, if 'yes' than = true, if 'no' than = false. (if its yes it will proceed to store the object into the database)
        if(book != null)
        {
            bookExist = true;
        }
        Genre genre = genreService.read(bookLocation.getGenreId());  //checking if genreId exist, if 'yes' than = true, if 'no' than = false. (if its yes it will proceed to store the object into the database)
        if(genre != null)
        {
            genreExist = true;
        }

        if(bookExist && genreExist) // Now we compare the two queries above, if they both exists than it will create the bookLocation object
        {
            return bookLocationService.create(bookLocation);
        }
        else
            return BookLocationFactory.createBookLocation(" ", " ");
    }
}
*/
