package com.microservice.user.domain.model.user;

import java.util.List;

public interface UserRepository {
    User findById(UserId id);
    List<User> findAll();
    void add(User user);
    void update(User user);
    void delete(UserId id);
}
