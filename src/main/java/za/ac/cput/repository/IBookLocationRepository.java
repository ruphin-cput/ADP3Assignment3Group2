package za.ac.cput.repository;

import za.ac.cput.entity.BookLocation;

import java.util.Set;

/**
 * iBookLocationRepository.java
 *
 * @author: Melven Johannes Booysen (219201277)
 * Date: 25 August 2021
 */

public interface IBookLocationRepository extends IRepository<BookLocation, String>
{
    public Set<BookLocation> getAll();
}
