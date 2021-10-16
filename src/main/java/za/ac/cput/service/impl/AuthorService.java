package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Author;
import za.ac.cput.repository.AuthorRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//This package "Service" - is the business logic layer that exposes selected functions of the repository.
//And this is where you indicate which methods will be put to use from the repository.
@Service  //NB add the @Service to avoid errors
public class AuthorService implements IAuthorService
{
    private static AuthorService service = null;

    @Autowired
    private AuthorRepository repository;

    @Override
    public Author create(Author author) {
           return this.repository.save(author);
    }

    @Override
    public Author read(String authorId) {
        return this.repository.findById(authorId).orElse(null);
    }

    @Override
    public Author update(Author author) {
        if(this.repository.existsById(author.getAuthorId()))
            return this.repository.save(author);
        return null;
    }

    @Override
    public boolean delete(String authorId) {
        this.repository.deleteById(authorId);
        if (this.repository.existsById(authorId))
            return false;
        else
            return true;
    }

    @Override
    public Set<Author> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    //Trying to find something specific and not everything like the code above
    public Set<Author> getAllAuthorsBeginningWithA()
    {
        Set<Author>authorWithA = new HashSet<Author>(); // instantiating the object
        Set<Author> authors = getAll();
        for(Author author:authors) //linear search
        {
            if(author.getName().trim().toLowerCase().startsWith("a")) //narrowing the search
            {
                authorWithA.add(author);
            }
        }
        return authorWithA;
    }

    public Author getAuthorGivenBio(String bio)
    {
        Author a = null;
        Set<Author> authors = getAll();
        for(Author author : authors)
        {
            if(author.getBio().equals(bio))
            {
                a = author;
                break;
            }
        }
        return a;
    }

}

