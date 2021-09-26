package za.ac.cput.service.impl;

import za.ac.cput.entity.UserRole;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IUserRoleService extends IService<UserRole ,String> {
    public Set<UserRole> getAll();
}
