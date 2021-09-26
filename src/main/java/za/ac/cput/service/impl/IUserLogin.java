package za.ac.cput.service.impl;

import za.ac.cput.entity.UserLogin;
import za.ac.cput.service.IService;

import java.util.*;

public interface IUserLogin extends IService<UserLogin,String> {
    public Set<UserLogin> getAll();
}
