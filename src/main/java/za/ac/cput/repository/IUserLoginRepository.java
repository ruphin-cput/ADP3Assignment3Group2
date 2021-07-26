package za.ac.cput.Repository;

import za.ac.cput.Entity.UserLogin;

import java.util.*;

public interface IUserLoginRepository extends IRepository<UserLogin, String>{
    public Set<UserLogin> getAll();
}
