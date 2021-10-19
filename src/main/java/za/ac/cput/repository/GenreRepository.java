package za.ac.cput.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Genre;
/**
 * GenreRepository.java
 * @author Plamedie Bitota Bukasa (219260532)
 * Genre Repository Interface
 * Date: 28th July 2021
 */


@Repository
public interface GenreRepository extends JpaRepository<Genre,String>
{


}

