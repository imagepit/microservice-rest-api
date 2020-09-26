package com.microservice.user.infrastructure.persistence.dummy;

import com.microservice.user.domain.model.user.*;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryDummy implements UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepositoryDummy(){
        users.add(new User(
                new UserId("takahashi@example.com"),
                new Name("高橋"),
                new Password("01234abcde")
        ));
        users.add(new User(
                new UserId("tanaka@example.com"),
                new Name("田中"),
                new Password("abcde01234")
        ));
        users.add(new User(
                new UserId("sato@example.com"),
                new Name("佐藤"),
                new Password("fghij56789")
        ));
    }

    @Override
    public User findById(UserId id) {
        for (User user: users) {
            if(user.id().equals(id)){ return user; }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public void update(User user) {
        for ( int i = 0 ; i < users.size() ; i++) {
            if(users.get(i).id().equals(user.id())){ users.set(i,user); }
        }
    }

    @Override
    public void delete(UserId id) {
        for ( int i = 0 ; i < users.size() ; i++) {
            if(users.get(i).id().equals(id)){ users.remove(i); }
        }
    }
}
