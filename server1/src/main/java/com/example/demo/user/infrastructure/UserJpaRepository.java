package com.example.demo.user.infrastructure;

import com.example.demo.user.domain.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByIdAndStatus(long id, UserStatus status);

    Optional<UserEntity> findByEmailAndStatus(String email, UserStatus status);
}
