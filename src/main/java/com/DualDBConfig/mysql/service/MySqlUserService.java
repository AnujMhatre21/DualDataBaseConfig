package com.DualDBConfig.mysql.service;

import java.util.List;
import java.util.Optional;

import com.DualDBConfig.mysql.entity.MySqlUser;

public interface MySqlUserService {
    MySqlUser createUser(MySqlUser user);
    Optional<MySqlUser> getUserById(Long id);
    Optional<MySqlUser> getUserByUsername(String username);
    List<MySqlUser> getAllUsers();
    MySqlUser updateUser(MySqlUser user);
    void deleteUser(Long id);
}
