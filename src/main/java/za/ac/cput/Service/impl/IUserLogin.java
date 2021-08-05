package za.ac.cput.Service.impl;

import za.ac.cput.Entity.UserLogin;
import za.ac.cput.Service.IService;

import java.util.*;

public interface IUserLogin extends IService<UserLogin,String> {
    public Set<UserLogin> getAll();
}
