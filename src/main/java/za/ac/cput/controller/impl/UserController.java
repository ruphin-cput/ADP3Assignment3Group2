package za.ac.cput.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.entity.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.service.impl.RoleService;
import za.ac.cput.service.impl.UserRoleService;
import za.ac.cput.service.impl.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleService roleService;

    @PostMapping
    public User create(@RequestBody User user){
        user = UserFactory.createUser(user.getName(), user.getSurname(), user.getCellphone(), user.getEmail(), user.getAddress());
        return userService.create(user);

    }
}
