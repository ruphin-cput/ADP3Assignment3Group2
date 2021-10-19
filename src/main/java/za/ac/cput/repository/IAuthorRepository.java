package za.ac.cput.repository;

import za.ac.cput.entity.Author;

import java.util.Set;

/**
 * iAuthorRepository.java
 *
 * @author: Melven Johannes Booysen (219201277)
 * Date: 25 August 2021
 */
@Deprecated
public interface IAuthorRepository extends IRepository<Author, String>
{
    public Set<Author> getAll();
}

