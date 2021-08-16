package za.ac.cput.repository;

import za.ac.cput.entity.UserLogin;

import java.util.HashSet;
import java.util.*;

public class UserLoginRepository implements IUserLoginRepository{
    private static UserLoginRepository repository = null;
    private Set<UserLogin> userloginDB = null;

    private UserLoginRepository(){
        userloginDB = new HashSet<UserLogin>();
    }

    public static UserLoginRepository getRepository(){
        if (repository == null) {
            repository = new UserLoginRepository();
        }
        return repository;
    }

    @Override
    public UserLogin create(UserLogin userLogin) {
        boolean success = userloginDB.add(userLogin);
        if(!success)
            return null;
        return userLogin;
    }

    @Override
    public UserLogin read(String userId) {
        for(UserLogin u: userloginDB)
        {
            if(u.getUserId().equals(userId)){
                return u;
            }
        }
        return null;
    }

    @Override
    public UserLogin update(UserLogin userLogin) {
        UserLogin oldUser = read(userLogin.getUserId());
        if(oldUser != null) {
            userloginDB.remove(oldUser);
            userloginDB.add(userLogin);
            return userLogin;
        }
        return userLogin;
    }

    @Override
    public boolean delete(String userId) {
        UserLogin UsertoDelete = read(userId);
        if(UsertoDelete == null)
        return false;
        userloginDB.remove(UsertoDelete);
        return true;
    }

    @Override
    public Set<UserLogin> getAll() {
        return userloginDB;
    }
}
