package uz.bellissimo.g34springbootcaching;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import uz.bellissimo.g34springbootcaching.feign.UserFeign;
import uz.bellissimo.g34springbootcaching.repo.UserRepository;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
@EnableScheduling
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
