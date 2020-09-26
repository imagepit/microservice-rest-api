package com.microservice.user.domain.model.user;

import com.microservice.user.domain.model.ValueObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password implements ValueObject {
    //-----------------
    // フィールド
    //-----------------
    private String value;
    //-----------------
    // コンストラクタ
    //-----------------
    public Password(String value) {
        if(value == null)
            throw new IllegalArgumentException("パスワードは必須です");
        if(!this.validateAlNum(value))
            throw new IllegalArgumentException("パスワードは半角英数字にしないといけません");
        if(!(value.length() >= 10 && value.length() <= 20))
            throw new IllegalArgumentException("パスワードは10文字以上20文字以内です");
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
        if (!(obj instanceof Password)) { return false; }
        Password other = (Password)obj;
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
    //-----------------
    // バリデート
    //-----------------
    private Boolean validateAlNum(String value){
        Pattern p = Pattern.compile("^[0-9a-zA-Z]+$");
        Matcher m = p.matcher(value);
        return m.find();
    }
}
