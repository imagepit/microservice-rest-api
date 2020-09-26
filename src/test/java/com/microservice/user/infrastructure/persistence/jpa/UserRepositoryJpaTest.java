package com.microservice.user.infrastructure.persistence.jpa;

import com.microservice.user.domain.model.user.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserRepositoryJpaTest {
    @Autowired
    @Qualifier("userRepositoryJpa")
    UserRepository repository;

    @Sql({"/data.sql"})
    @Test
    public void testFind(){
        UserId id = new UserId("takahashi@example.com");
        User user = repository.findById(id);
        System.out.println(user);
        assertEquals(user.id(),id);
    }

    @Sql({"/data.sql"})
    @Test
    public void testFindAll(){
        List<User> users = repository.findAll();
        for(User u: users){ System.out.println(u); }
        assertEquals(3,users.size());
    }

    @Sql({"/data.sql"})
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

    @Sql({"/data.sql"})
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

    @Sql({"/data.sql"})
    @Test
    public void testDelete(){
        repository.delete(new UserId("takahashi@example.com"));
        List<User> users = repository.findAll();
        for(User u: users){ System.out.println(u); }
        assertEquals(2,users.size());
    }
}
