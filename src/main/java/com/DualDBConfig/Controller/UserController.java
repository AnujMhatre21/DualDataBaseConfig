package com.DualDBConfig.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.DualDBConfig.mysql.entity.MySqlUser;
import com.DualDBConfig.mysql.service.MySqlUserService;
import com.DualDBConfig.postgres.entity.PostgresUser;
import com.DualDBConfig.postgres.service.PostgresUserService;

@RestController
@RequestMapping("/api/users")
public class UserController  {
	
	private final PostgresUserService postgresUserService;
    private final MySqlUserService mysqlUserService;

    @Autowired
    public UserController(
        PostgresUserService postgresUserService, 
        MySqlUserService mysqlUserService
    ) {
        this.postgresUserService = postgresUserService;
        this.mysqlUserService = mysqlUserService;
    }

    // PostgreSQL User Endpoints
    @PostMapping("/postgres")
    public ResponseEntity<PostgresUser> createPostgresUser(@RequestBody PostgresUser user) {
    	PostgresUser postgresUser = new PostgresUser();
//    	postgresUser.setId(1L);
    	postgresUser.setEmail("AnujM@gmail.com");
    	postgresUser.setUsername("AnujM");
    	postgresUser.setPassword("anuj@123");
        PostgresUser createdUser = postgresUserService.createUser(postgresUser);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/postgres/{username}")
    public ResponseEntity<PostgresUser> getPostgresUser(@PathVariable String username) {
        return postgresUserService.getUserByUsername(username)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // MySQL User Endpoints
    @PostMapping("/mysql")
    public ResponseEntity<MySqlUser> createMySqlUser(@RequestBody MySqlUser user) {
        MySqlUser createdUser = mysqlUserService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/mysql/{username}")
    public ResponseEntity<MySqlUser> getMySqlUser(@PathVariable String username) {
        return mysqlUserService.getUserByUsername(username)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

}
