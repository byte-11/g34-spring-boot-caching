package uz.bellissimo.g34springbootcaching.feign;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import uz.bellissimo.g34springbootcaching.domain.user.User;

@FeignClient(name = "userFeign", url = "https://jsonplaceholder.typicode.com/users")
public interface UserFeign {
    @GetMapping
    List<User> getAllUser();
}
