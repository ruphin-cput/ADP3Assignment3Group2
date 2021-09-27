package za.ac.cput.service.impl;

import za.ac.cput.entity.Author;
import za.ac.cput.service.IService;

import java.util.Set;

/**
 * iAuthorService.java
 *
 * @author: Melven Johannes Booysen (219201277)
 * Date: 25 August 2021
 */

public interface IAuthorService extends IService<Author, String>
{
    public Set<Author> getAll();
}
