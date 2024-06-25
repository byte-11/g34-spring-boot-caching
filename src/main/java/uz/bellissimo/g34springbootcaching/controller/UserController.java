package uz.bellissimo.g34springbootcaching.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
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
    private final Cache cache;

    public UserController(UserService userService, @Qualifier("cacheManager") CacheManager cacheManager) {
        this.userService = userService;
        this.cache = cacheManager.getCache("users");
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        User user = cache.get(id, User.class);
        if (user == null) {
            user = userService.getUserById(id);
            cache.put(id, user);
        }
        return user;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        User updateUser = userService.updateUser(id, user);
        cache.put(id, updateUser);
        return updateUser;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        cache.evictIfPresent(id);
    }
}
