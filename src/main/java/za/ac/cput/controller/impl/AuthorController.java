package za.ac.cput.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Author;
import za.ac.cput.factory.AuthorFactory;
import za.ac.cput.service.impl.AuthorService;

import java.util.Set;

//This package "Controller" - is used to expose our services. (e.g. display)
@RestController        //This indicates that this is a controller
@RequestMapping("/author")   //This is the entry point of the application
public class AuthorController
{
    @Autowired //This means you are injecting the constructor into the application
    private AuthorService authorService;

    @PostMapping("/create")
    public Author create(@RequestBody Author author) {
        author = AuthorFactory.createAuthor(author.getName(), author.getSurname(), author.getBio());
        return authorService.create(author);
    }

    @GetMapping("/read/{authorId}") //I am passing a parameter (you do this for 'get' Http methods only)
    public Author read(@PathVariable String authorId)
    {
        return authorService.read(authorId);
    }

    @PostMapping("/update")
    public Author update(@RequestBody Author author)
    {
        return authorService.update(author);
    }

    @PostMapping("/delete/{authorId}") //I am passing a parameter (you do this for 'get' Http methods only)
    public boolean delete(@PathVariable String authorId)
    {
        return authorService.delete(authorId);
    }

    @GetMapping("/getAll") //Might need to change it to getall if it doesnt return the data
    @ResponseBody
    public Set<Author> getAll()
    {
        return authorService.getAll();
    }

    @GetMapping("/getAllAuthorsBeginningWithA") //The new method created in AuthorService
    public Set<Author> authorWithA()
    {
        return authorService.getAllAuthorsBeginningWithA();
    }
}
