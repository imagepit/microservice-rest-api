package com.microservice.user.domain.model.user;

import com.microservice.user.domain.model.ValueObject;

public class UserId implements ValueObject {
    //----------------
    // フィールド
    //----------------
    private String value;
    //----------------
    // コンストラクタ
    //----------------
    public UserId(String id){
        if(id == null)
            throw new IllegalArgumentException("ユーザIDは必須です");
        if(!this.validateEmailFormat(id))
            throw new IllegalArgumentException("ユーザIDはEメールアドレス形式の必要があります");
        this.value = id;
    }
    //----------------
    // ゲッター
    //----------------
    public String value(){
        return this.value;
    }
    //----------------
    // 等価性
    //----------------
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UserId other = (UserId) obj;
        return this.value().equals(other.value());
    }
    @Override
    public int hashCode() {
        return this.value().hashCode();
    }
    //----------------
    // インスタンス出力
    //----------------
    @Override
    public String toString() {
        return String.format("UserId[value=%s]",this.value);
    }

    //----------------
    // バリデート
    //----------------
    private Boolean validateEmailFormat(String value){
        String mailFormat = "^[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+(\\.[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+)*+(.*)@[a-zA-Z0-9][a-zA-Z0-9\\-]*(\\.[a-zA-Z0-9\\-]+)+$";
        if(!value.matches(mailFormat))
            return false;
        return true;
    }
}
