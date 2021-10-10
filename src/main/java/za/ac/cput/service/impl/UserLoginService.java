<<<<<<< HEAD
package za.ac.cput.service.impl;

import za.ac.cput.entity.UserLogin;
import za.ac.cput.repository.UserLoginRepository;

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
        return this.repository.create(userLogin);
    }

    @Override
    public UserLogin read(String s) {
        return this.repository.read(s);
    }

    @Override
    public UserLogin update(UserLogin userLogin) {
        return this.repository.update(userLogin);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }

    @Override
    public Set<UserLogin> getAll() {
        return this.repository.getAll();
    }
}
=======
package za.ac.cput.service.impl;

import za.ac.cput.entity.UserLogin;
import za.ac.cput.repository.UserLoginRepository;

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
        return this.repository.create(userLogin);
    }

    @Override
    public UserLogin read(String s) {
        return this.repository.read(s);
    }

    @Override
    public UserLogin update(UserLogin userLogin) {
        return this.repository.update(userLogin);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }

    @Override
    public Set<UserLogin> getAll() {
        return this.repository.getAll();
    }
}
>>>>>>> 5f71e25dfbc24a5a533788550a294bb02db12b1c
