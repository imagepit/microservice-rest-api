package com.microservice.user.infrastructure.persistence.jpa;

import com.microservice.user.domain.model.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryJpa implements UserRepository {
    @Autowired
    UserJpaRepository userJpaRepository;

    @Override
    public User findById(UserId id) {
        Optional<UserJpaModel> userJpaModel = userJpaRepository.findById(id.value());
        return convertUserDomainModel(userJpaModel.orElseThrow(IllegalStateException::new));
    }

    @Override
    public List<User> findAll() {
        List<UserJpaModel> userJpaModels = userJpaRepository.findAll();
        return convertUserDomainModels(userJpaModels);
    }

    @Override
    public void add(User user) {
        userJpaRepository.save(convertUserJpaModel(user));
    }

    @Override
    public void update(User user) {
        userJpaRepository.save(convertUserJpaModel(user));
    }

    @Override
    public void delete(UserId user) {
        userJpaRepository.delete(convertUserJpaModel(new User(user,null,null)));
    }

    private User convertUserDomainModel(UserJpaModel userJpaModel){
        return new User(
                new UserId(userJpaModel.getId()),
                new Name(userJpaModel.getName()),
                new Password(userJpaModel.getPassword())
        );
    }

    private List<User> convertUserDomainModels(List<UserJpaModel> userJpaModels){
        List<User> users = new ArrayList<>();
        for(UserJpaModel userJpaModel : userJpaModels){
            users.add(convertUserDomainModel(userJpaModel));
        }
        return users;
    }

    private UserJpaModel convertUserJpaModel(User user){
        UserJpaModel userJpaModel = new UserJpaModel();
        userJpaModel.setId(user.id().value());
        if(user.name() != null)
            userJpaModel.setName(user.name().value());
        if(user.password() != null)
            userJpaModel.setPassword(user.password().value());
        return userJpaModel;
    }
}
