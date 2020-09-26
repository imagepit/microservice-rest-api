package com.microservice.user.application.user;

import com.microservice.user.domain.model.user.User;
import com.microservice.user.domain.model.user.UserId;
import java.util.List;

public interface UserService {
    List<UserDTO> findAll();
    UserDTO findById(UserId id);
    UserDTO add(User user);
    UserDTO update(User user);
    void delete(User user);
}
