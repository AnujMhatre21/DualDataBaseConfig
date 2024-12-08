package com.DualDBConfig.postgres.service;

import java.util.List;
import java.util.Optional;

import com.DualDBConfig.postgres.entity.PostgresUser;

public interface PostgresUserService {
    PostgresUser createUser(PostgresUser user);
    Optional<PostgresUser> getUserById(Long id);
    Optional<PostgresUser> getUserByUsername(String username);
    List<PostgresUser> getAllUsers();
    PostgresUser updateUser(PostgresUser user);
    void deleteUser(Long id);
}