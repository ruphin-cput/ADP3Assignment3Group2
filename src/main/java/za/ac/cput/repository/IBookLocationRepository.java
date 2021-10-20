package za.ac.cput.repository;

import za.ac.cput.entity.BookLocation;
import za.ac.cput.entity.BookLocationId;

import java.util.Set;

/**
 * iBookLocationRepository.java
 *
 * @author: Melven Johannes Booysen (219201277)
 * Date: 25 August 2021
 */
@Deprecated
public interface IBookLocationRepository extends IRepository<BookLocation, BookLocationId>
{
    public Set<BookLocation> getAll();
}
