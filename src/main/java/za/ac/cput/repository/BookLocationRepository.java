package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.BookLocation;

/**
 * iBookLocationRepository.java
 *
 * @author: Melven Johannes Booysen (219201277)
 * Date: 25 August 2021
 */
public interface BookLocationRepository extends JpaRepository<BookLocation, String> {
}
