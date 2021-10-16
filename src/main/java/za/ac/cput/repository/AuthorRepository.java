package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Author;

/**
 * iAuthorRepository.java
 *
 * @author: Melven Johannes Booysen (219201277)
 * Date: 25 August 2021
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {
}
