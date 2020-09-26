package com.microservice.user;

import com.microservice.user.application.user.UserService;
import com.microservice.user.application.user.UserServiceImpl;
import com.microservice.user.domain.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:context-infrastructure-persistence.xml"})
public class AppConfig {
    @Autowired
    UserRepository userRepository;

    @Bean
    public UserService userService(){
        return new UserServiceImpl(userRepository);
    }
}