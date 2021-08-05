package za.ac.cput.Service.impl;

import za.ac.cput.Entity.UserLogin;
import za.ac.cput.Repository.UserLoginRepository;

import java.util.*;

public class UserLoginService implements IUserLogin{
    private static UserLoginService service = null;
    private UserLoginRepository repository = null;

    private UserLoginService(){ this.repository = UserLoginRepository.getRepository();}

    public static UserLoginService getService() {
        if (service == null) {
            service = new UserLoginService();
        }
        return service;
    }

    @Override
    public UserLogin create(UserLogin userLogin) {
        return this.repository.Create(userLogin);
    }

    @Override
    public UserLogin read(String s) {
        return this.repository.Read(s);
    }

    @Override
    public UserLogin update(UserLogin userLogin) {
        return this.repository.Update(userLogin);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.Delete(s);
    }

    @Override
    public Set<UserLogin> getAll() {
        return this.repository.getAll();
    }
}
