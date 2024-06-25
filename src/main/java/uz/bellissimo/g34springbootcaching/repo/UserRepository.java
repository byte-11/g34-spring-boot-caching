package uz.bellissimo.g34springbootcaching.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bellissimo.g34springbootcaching.domain.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}