
/**  IGenreService.java
 Genre Service interface
 Author: Plamedie Bitota 219260532
 Date: 1st  August 2021
 */
package za.ac.cput.service.impl;

import za.ac.cput.entity.Genre;
import za.ac.cput.service.IService;

import java.util.Set;

    public interface IGenreService extends IService<Genre,String> {
        public Set<Genre> getAll();
    }


