package com.microservice.user.infrastructure.persistence.dummy;

import com.microservice.user.domain.model.user.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRepositoryDummyTest {
    UserRepository repository;

    @BeforeEach
    public void setup(){ repository = new UserRepositoryDummy(); }

    @Test
    public void testFindById(){
        UserId id = new UserId("takahashi@example.com");
        User user = repository.findById(id);
        System.out.println(user);
        assertEquals(user.id(),id);
    }

    @Test
    public void testFindAll(){
        List<User> users = repository.findAll();
        for(User u: users){ System.out.println(u); }
        assertEquals(3,users.size());
    }

    @Test
    public void testAdd(){
        User addedUser = new User(
                new UserId("suzuki@example.com"),
                new Name("鈴木"),
                new Password("abcde01234")
        );
        repository.add(addedUser);
        List<User> users = repository.findAll();
        for(User u: users){ System.out.println(u); }
        assertEquals(4,users.size());
    }

    @Test
    public void testUpdate(){
        User updaetUser = new User(
                new UserId("takahashi@example.com"),
                new Name("高橋2"),
                new Password("vwxyz98765")
        );
        repository.update(updaetUser);
        List<User> users = repository.findAll();
        for(User u: users){ System.out.println(u); }
        assertEquals(3,users.size());
        assertEquals(updaetUser.id(), repository.findById(updaetUser.id()).id());
        assertEquals(updaetUser.name(), repository.findById(updaetUser.id()).name());
        assertEquals(updaetUser.password(), repository.findById(updaetUser.id()).password());
    }

    @Test
    public void testDelete(){
        UserId deleteUserId = new UserId("takahashi@example.com");
        repository.delete(deleteUserId);
        List<User> users = repository.findAll();
        for(User u: users){ System.out.println(u); }
        assertEquals(2,users.size());
        assertEquals(null, repository.findById(deleteUserId));
    }
}
