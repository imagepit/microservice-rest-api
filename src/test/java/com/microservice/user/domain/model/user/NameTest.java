package com.microservice.user.domain.model.user;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
public class NameTest {
    @Test
    public void testEquals(){
        Name name1 = new Name("高橋");
        Name name2 = new Name("田中");
        Name name3 = new Name("高橋");
        assertEquals(name1,name1);
        assertNotEquals(name1,name2);
        assertNotEquals(name2,name3);
        assertEquals(name1,name3);
    }
    @Test
    public void testNotNull(){
        try {
            Name name = new Name("高橋");
            assertEquals("高橋",name.value());
        } catch (IllegalArgumentException e){
        }
        try {
            Name name = new Name(null);
        } catch (IllegalArgumentException e){
            System.out.println("例外発生");
            assertEquals("名前は必須です",e.getMessage());
        }
    }
    @Test
    public void testLengthWithin10(){
        try {
            // 10文字
            Name name1 = new Name("0123456789");
            Name name2 = new Name("abcdefghij");
            Name name3 = new Name("あいうえおかきくけこ");
            Name name4 = new Name("高橋高橋高橋高橋高橋");
            assertEquals("0123456789",name1.value());
            assertEquals("abcdefghij",name2.value());
            assertEquals("あいうえおかきくけこ",name3.value());
            assertEquals("高橋高橋高橋高橋高橋",name4.value());
        } catch (IllegalArgumentException e){
        }
        // 11文字
        try {
            Name name = new Name("01234567890");
        } catch (IllegalArgumentException e){
            System.out.println("例外発生");
            assertEquals("名前は10文字以内です",e.getMessage());
        }
        try {
            Name name = new Name("abcdefghijk");
        } catch (IllegalArgumentException e){
            System.out.println("例外発生");
            assertEquals("名前は10文字以内です",e.getMessage());
        }
        try {
            Name name = new Name("あいうえおかきくけこさ");
        } catch (IllegalArgumentException e){
            System.out.println("例外発生");
            assertEquals("名前は10文字以内です",e.getMessage());
        }
        try {
            Name name = new Name("高橋高橋高橋高橋高橋高");
        } catch (IllegalArgumentException e){
            System.out.println("例外発生");
            assertEquals("名前は10文字以内です",e.getMessage());
        }
    }
}
