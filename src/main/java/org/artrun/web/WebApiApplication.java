package org.artrun.web;

import java.util.ArrayList;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.CachingUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@SpringBootApplication
public class WebApiApplication {

	private static final Logger log = LoggerFactory.getLogger(WebApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WebApiApplication.class, args);
	}
}
