package za.ac.cput.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.service.impl.UserService;

import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User create(@RequestBody User user){
        user = UserFactory.createUser(user.getName(), user.getSurname(), user.getCellphone(), user.getEmail(), user.getAddress());
        return userService.create(user);
    }

    @GetMapping("/read/{id}")
    public User read(@PathVariable String id) { return userService.read(id); }

    @PutMapping("/update")
    public User update(@RequestBody User user) { return userService.update(user); }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){ return userService.delete(id);}

    @GetMapping("/getAll")
    public Set<User> getAll(){ return userService.getAll(); }
}
