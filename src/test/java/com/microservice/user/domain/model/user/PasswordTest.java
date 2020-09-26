package com.microservice.user.domain.model.user;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
public class PasswordTest {
    @Test
    public void testEquals(){
        Password pass1 = new Password("abcde12345");
        Password pass2 = new Password("fghij67890");
        Password pass3 = new Password("abcde12345");
        assertEquals(pass1,pass1);
        assertNotEquals(pass1,pass2);
        assertNotEquals(pass2,pass3);
        assertEquals(pass1,pass3);
    }
    @Test
    public void testNotNull(){
        try {
            Password pass = new Password("abcde12345");
            assertEquals("abcde12345",pass.value());
        } catch (IllegalArgumentException e){
        }
        try {
            Password pass = new Password(null);
        } catch (IllegalArgumentException e){
            System.out.println("例外発生");
            assertEquals("パスワードは必須です",e.getMessage());
        }
    }
    @Test
    public void testLengthBetween10and20(){
        // 20文字
        try {
            Password pass = new Password("abcde12345abcde12345");
            assertEquals("abcde12345abcde12345",pass.value());
        } catch (IllegalArgumentException e){
            assertEquals("パスワードは10文字以上20文字以内です",e.getMessage());
        }
        // 21文字
        try {
            Password pass = new Password("abcde12345abcde123456");
        } catch (IllegalArgumentException e){
            System.out.println("例外発生");
            assertEquals("パスワードは10文字以上20文字以内です",e.getMessage());
        }
    }
    @Test
    public void testAlNum(){
        // 英字のみ
        try {
            Password pass = new Password("abcdefghij");
        } catch (IllegalArgumentException e){
            System.out.println("例外発生");
            assertEquals("パスワードは半角英数字にしないといけません",e.getMessage());
        }
        // 数字のみ
        try {
            Password pass = new Password("0123456789");
        } catch (IllegalArgumentException e){
            System.out.println("例外発生");
            assertEquals("パスワードは半角英数字にしないといけません",e.getMessage());
        }
        // 全角混入
        try {
            Password pass = new Password("abcde1234あ");
        } catch (IllegalArgumentException e){
            System.out.println("例外発生");
            assertEquals("パスワードは半角英数字にしないといけません",e.getMessage());
        }
    }
}