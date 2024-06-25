package uz.bellissimo.g34springbootcaching.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bellissimo.g34springbootcaching.domain.user.User;
import uz.bellissimo.g34springbootcaching.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final Map<Long, User> USER_CACHE = new ConcurrentHashMap<>();

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        User user = USER_CACHE.get(id);
        if (user == null) {
            user = userService.getUserById(id);
            USER_CACHE.put(id, user);
        }
        return user;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        User updateUser = userService.updateUser(id, user);
        USER_CACHE.put(id, updateUser);
        return updateUser;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        USER_CACHE.remove(id);
    }
}
