package com.DualDBConfig.postgres.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DualDBConfig.postgres.entity.PostgresUser;
import com.DualDBConfig.postgres.repository.PostgresUserRepository;
import com.DualDBConfig.postgres.service.PostgresUserService;

@Service
@Transactional(transactionManager = "postgresTransactionManager")
public class PostgresUserServiceImpl implements PostgresUserService {

    private final PostgresUserRepository userRepository;

    @Autowired
    public PostgresUserServiceImpl(PostgresUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public PostgresUser createUser(PostgresUser user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public Optional<PostgresUser> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<PostgresUser> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<PostgresUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public PostgresUser updateUser(PostgresUser user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}