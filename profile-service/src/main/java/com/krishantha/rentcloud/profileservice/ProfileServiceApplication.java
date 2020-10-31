package com.krishantha.rentcloud.profileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@ComponentScan(basePackages = {"com.*"})
@EntityScan("com.krishantha.rentcloud.commos.model")
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ProfileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileServiceApplication.class, args);
	}

}
