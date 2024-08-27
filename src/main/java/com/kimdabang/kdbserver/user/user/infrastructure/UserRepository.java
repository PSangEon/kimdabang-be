package com.kimdabang.kdbserver.user.user.infrastructure;

import com.kimdabang.kdbserver.user.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
