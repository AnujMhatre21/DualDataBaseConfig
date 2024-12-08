package com.DualDBConfig.mysql.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DualDBConfig.mysql.entity.MySqlUser;
import com.DualDBConfig.mysql.repository.MySqlUserRepository;
import com.DualDBConfig.mysql.service.MySqlUserService;

@Service
@Transactional(transactionManager = "mysqlTransactionManager")
public class MySqlUserServiceImpl implements MySqlUserService {

	private final MySqlUserRepository userRepository;

	@Autowired
	public MySqlUserServiceImpl(MySqlUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public MySqlUser createUser(MySqlUser user) {
		if (userRepository.existsByUsername(user.getUsername())) {
			throw new RuntimeException("Username already exists");
		}
		return userRepository.save(user);
	}

	@Override
	public Optional<MySqlUser> getUserById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public Optional<MySqlUser> getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<MySqlUser> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public MySqlUser updateUser(MySqlUser user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
