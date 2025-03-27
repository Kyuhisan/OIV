package com.encryptedSignUp.encryptedSignUp.repository;

import java.util.Optional;
import com.encryptedSignUp.encryptedSignUp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
}
