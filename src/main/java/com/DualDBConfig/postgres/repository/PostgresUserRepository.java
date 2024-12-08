package com.DualDBConfig.postgres.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DualDBConfig.postgres.entity.PostgresUser;

@Repository
public interface PostgresUserRepository extends JpaRepository<PostgresUser, Long> {
    Optional<PostgresUser> findByUsername(String username);
    Optional<PostgresUser> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}