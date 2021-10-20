package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.entity.UserLogin;
import za.ac.cput.repository.UserLoginRepository;

import java.util.Set;
import java.util.stream.Collectors;

public class UserLoginService implements IUserLoginService{
    private static UserLoginService service = null;

    @Autowired
    private UserLoginRepository repository;

    /* private UserLoginService(){ this.repository = UserLoginRepository.getRepository();}

    public static UserLoginService getService() {
        if (service == null) {
            service = new UserLoginService();
        }
        return service;
    }

    */

    @Override
    public UserLogin create(UserLogin userLogin) {
        return this.repository.save(userLogin);
    }

    @Override
    public UserLogin read(String userId) {
        return this.repository.findById(userId).orElse(null);
    }

    @Override
    public UserLogin update(UserLogin userLogin) {
        if(this.repository.existsById(userLogin.getUserId()))
            return this.repository.save(userLogin);
        return null;
    }

    @Override
    public boolean delete(String userId) {
        this.repository.deleteById(userId);
        if (this.repository.existsById(userId))
            return false;
        else
            return true;
    }

    @Override
    public Set<UserLogin> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
