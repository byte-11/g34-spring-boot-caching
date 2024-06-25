package uz.bellissimo.g34springbootcaching;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import uz.bellissimo.g34springbootcaching.feign.UserFeign;
import uz.bellissimo.g34springbootcaching.repo.UserRepository;

@SpringBootApplication
@EnableFeignClients
public class G34SpringBootCachingApplication {

    public static void main(String[] args) {
        SpringApplication.run(G34SpringBootCachingApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository, UserFeign userFeign) {
        return args -> {
            userRepository.saveAll(
                    userFeign.getAllUser()
            );
        };
    }
}
