package com.microservice.user.domain.model.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    /**
     * 等価性のテスト（識別子は同じであれば等しいとみなすかのテスト）
     */
    @Test
    public void testEquals(){
        User user1 = new User(new UserId("user1@example.com"),new Name("user1"),new Password("user1password"));
        User user2 = new User(new UserId("user2@example.com"),new Name("user2"),new Password("user2password"));
        User user3 = new User(new UserId("user1@example.com"),new Name("user3"),new Password("user3password"));
        User user4 = user1.clone();
        assertNotEquals(user2, user1);
        assertEquals(user3, user1);
        assertEquals(user4, user1);
    }
}