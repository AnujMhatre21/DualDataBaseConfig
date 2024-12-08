package com.DualDBConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class DualDataBaseApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(DualDataBaseApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace(); // This will print full stack trace
		}
	}

}
