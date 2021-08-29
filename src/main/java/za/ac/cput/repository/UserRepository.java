package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.User;

import java.util.HashSet;
import java.util.Set;

/*  UserRepository.java
    User Repository implementation
    Author: Adriaan Burger(219014868)
    Date: 25 July 2021
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
