package za.ac.cput.service.impl;

import za.ac.cput.entity.BookLocation;
import za.ac.cput.service.IService;

import java.util.Set;

/**
 * iBookLocationService.java
 *
 * @author: Melven Johannes Booysen (219201277)
 * Date: 25 August 2021
 */

public interface IBookLocationService extends IService<BookLocation, String>
{
    public Set<BookLocation> getAll();
}

