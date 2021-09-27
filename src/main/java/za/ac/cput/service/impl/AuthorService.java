package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.Author;
import za.ac.cput.repository.AuthorRepository;

import java.util.HashSet;
import java.util.Set;

//This package "Service" - is the business logic layer that exposes selected functions of the repository.
//And this is where you indicate which methods will be put to use from the repository.
@Service  //NB add the @Service to avoid errors
public class AuthorService implements IAuthorService
{
    private static AuthorService service = null;
    private AuthorRepository repository = null;

    private AuthorService() { this.repository = AuthorRepository.getRepository();} //Need to fix

    public static AuthorService getService()
    {
        if(service == null)
        {
            service = new AuthorService();
        }
        return service;
    }

    @Override
    public Author create(Author author) {
        return this.repository.create(author);
    }

    @Override
    public Author read(String authorId) {
        return this.repository.read(authorId);
    }

    @Override
    public Author update(Author author) {
        return this.repository.update(author);
    }

    @Override
    public boolean delete(String authorId) {
        return this.repository.delete(authorId);
    }

    @Override
    public Set<Author> getAll() {
        return this.repository.getAll();
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
}
