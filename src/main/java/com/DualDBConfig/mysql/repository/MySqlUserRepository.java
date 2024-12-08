package com.DualDBConfig.mysql.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DualDBConfig.mysql.entity.MySqlUser;

@Repository
public interface MySqlUserRepository extends JpaRepository<MySqlUser, Long> {
    Optional<MySqlUser> findByUsername(String username);
    Optional<MySqlUser> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}