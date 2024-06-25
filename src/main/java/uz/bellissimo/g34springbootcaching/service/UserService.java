package uz.bellissimo.g34springbootcaching.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import uz.bellissimo.g34springbootcaching.domain.user.User;
import uz.bellissimo.g34springbootcaching.repo.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @SneakyThrows
    public User getUserById(Long id) {
        Thread.sleep(10_000);
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );
    }

    public User updateUser(Long id, User dto) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );

        dto.setId(user.getId());
        return userRepository.save(dto);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
