package com.microservice.user.domain.model.user;

import com.microservice.user.domain.model.ValueObject;

public class Name implements ValueObject {
    //-----------------
    // フィールド
    //-----------------
    private String value;
    //-----------------
    // コンストラクタ
    //-----------------
    public Name(String value) {
        if(value == null)
            throw new IllegalArgumentException("名前は必須です");
        if(!(value.length() <= 10))
            throw new IllegalArgumentException("名前は10文字以内です");
        this.value = value;
    }
    //-----------------
    // ゲッター
    //-----------------
    public String value(){ return this.value; }
    //-----------------
    // 等価性
    //-----------------
    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (this == obj) { return true; }
        if (!(obj instanceof Name)) { return false; }
        Name other = (Name)obj;
        return this.value.equals(other.value());
    }
    @Override
    public int hashCode() {
        return this.value().hashCode();
    }
    //-----------------
    // インスタンス出力
    //-----------------
    @Override
    public String toString() {
        return this.value();
    }
}
