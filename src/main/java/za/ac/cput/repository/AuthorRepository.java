package za.ac.cput.repository;

import za.ac.cput.entity.Author;

import java.util.HashSet;
import java.util.Set;

//This package "Repository" - is how we store our information (e.g. updating information)
public class AuthorRepository implements IAuthorRepository
{
    private static AuthorRepository repository = null;
    private Set<Author> authorDB = null;

    private AuthorRepository() {authorDB = new HashSet<Author>();}

    public static AuthorRepository getRepository()
    {
        if(repository == null)
        {
            repository = new AuthorRepository();
        }
        return repository;
    }

    @Override
    public Author create(Author author)
    {
        boolean success = authorDB.add(author);
        if(!success)
            return null;
        return author;
    }

    @Override
    public Author read(String authorId)
    {
        Author author = authorDB.stream()
                .filter(e -> e.getAuthorId().equals(authorId))
                .findAny()
                .orElse(null);
        return author;
    }

    @Override
    public Author update(Author author)
    {
        Author oldAuthor = read(author.getAuthorId());
        if(oldAuthor != null)
        {
            authorDB.remove(oldAuthor);
            authorDB.add(author);
            return author;
        }
        return author;
    }

    @Override
    public boolean delete(String authorId)
    {
        Author authorToDelete = read(authorId);
        if(authorToDelete == null)
            return false;
        authorDB.remove(authorToDelete);
        return true;
    }


    @Override
    public Set<Author> getAll() {
        return authorDB;
    }
}

