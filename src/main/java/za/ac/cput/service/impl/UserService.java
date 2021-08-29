package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.User;
import za.ac.cput.repository.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;

/*  UserService.java
    User Service implementation
    Author: Adriaan Burger(219014868)
    Date: 27 July 2021
 */
@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository repository;

    @Override
    public User create(User user) {  return this.repository.save(user); }

    @Override
    public User read(String userId) {
        return this.repository
                .findById(userId)
                .orElse(null);
    }

    @Override
    public User update(User user) {
        if(this.repository.existsById(user.getUserID()))
            return this.repository.save(user);
        return null;
    }

    @Override
    public boolean delete(String userId) {
        this.repository.deleteById(userId);
        if(this.repository.existsById(userId))
            return false;
        else
            return true;
    }

    @Override
    public Set<User> getAll() {
        return this.repository
                .findAll()
                .stream()
                .collect(Collectors.toSet());
    }
}
