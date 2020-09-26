package com.microservice.user.domain.model.user;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UserIdTest {
    @Test
    public void testEquals(){
        UserId id1 = new UserId("tanaka@example.com");
        UserId id2 = new UserId("sato@example.com");
        UserId id3 = new UserId("tanaka@example.com");
        assertEquals(id1,id1);
        assertNotEquals(id1,id2);
        assertNotEquals(id2,id3);
        assertEquals(id1,id3);
    }
    @Test
    public void testNotNull(){
        try {
            UserId id = new UserId("tanaka@example.com");
            assertEquals("tanaka@example.com",id.value());
        } catch (IllegalArgumentException e){
            // assertEquals("名前は必須です",e.getMessage());
        }
        try {
            UserId id = new UserId(null);
            //assertEquals(null,name.value());
        } catch (IllegalArgumentException e){
            System.out.println("例外発生");
            assertEquals("ユーザIDは必須です",e.getMessage());
        }
    }
    @Test
    public void testEmailFormat(){
        try {
            UserId id = new UserId("abc");
        } catch (IllegalArgumentException e){
            System.out.println("例外発生");
            assertEquals("ユーザIDはEメールアドレス形式の必要があります",e.getMessage());
        }
        try {
            UserId id = new UserId("あいうえお");
        } catch (IllegalArgumentException e){
            System.out.println("例外発生");
            assertEquals("ユーザIDはEメールアドレス形式の必要があります",e.getMessage());
        }
        try {
            UserId id = new UserId("012345");
        } catch (IllegalArgumentException e){
            System.out.println("例外発生");
            assertEquals("ユーザIDはEメールアドレス形式の必要があります",e.getMessage());
        }
    }
}
