package com.microservice.user.application.user;

import com.microservice.user.domain.model.user.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    public void setUp(){
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void testFindById(){
        User expected = new User(
                new UserId("takahashi@example.com"),
                new Name("高橋"),
                new Password("aaaaaaaaaa")
        );
        when(userRepository.findById(new UserId("takahashi@example.com"))).thenReturn(expected);
        UserDTO actual = userService.findById(new UserId("takahashi@example.com"));
        assertEquals("takahashi@example.com",actual.getId());
        assertEquals("高橋",actual.getName());
        assertEquals("aaaaaaaaaa",actual.getPassword());
    }
}
