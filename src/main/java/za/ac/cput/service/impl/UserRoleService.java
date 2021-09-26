package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.UserRole;
import za.ac.cput.repository.UserRoleRepository;

import java.util.Set;
@Service
public class UserRoleService implements IUserRoleService {
    private static UserRoleService service = null;
    private UserRoleRepository repository = null;

    private UserRoleService() {this.repository = UserRoleRepository.getRepository();}

    public static UserRoleService getService(){
        if(service == null){
            service = new UserRoleService();
        }
        return service;
    }

    @Override
    public UserRole create(UserRole userRole) {
        return this.repository.create(userRole);
    }

    @Override
    public UserRole read(String userID) {
        return this.repository.read(userID);
    }

    @Override
    public UserRole update(UserRole userRole) {
        return this.repository.update(userRole);
    }

    @Override
    public boolean delete(String userID) {
        return this.repository.delete(userID);
    }

    @Override
    public Set<UserRole> getAll() {
        return this.repository.getAll();
    }
}
