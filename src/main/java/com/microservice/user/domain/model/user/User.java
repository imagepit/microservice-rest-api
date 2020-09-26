package com.microservice.user.domain.model.user;

import com.microservice.user.domain.model.Entity;

public class User implements Entity<User> {
    //-----------------
    // フィールド
    //-----------------
    private UserId id; // 識別子は値オブジェクトとして定義
    private Name name;
    private Password password;
    //-----------------
    // コンストラクタ
    //-----------------
    public User(UserId id,Name name,Password password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    //-----------------
    // ゲッター
    //-----------------
    public UserId id() { return id; }
    public Name name(){ return name; }
    public Password password(){ return password; }
    //----------------
    // でバック
    //----------------
    @Override
    public String toString() {
        return String.format(
                "User[id=%s,name=%s,password=%s]",
                this.id(),
                this.name(),
                this.password()
        );
    }
    //-----------------
    // 等価性
    // エンティティは識別子の値が等しいかどうかで判断する
    //-----------------
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User other = (User)obj;
        return this.id.value().equals(other.id().value());
    }
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
    @Override
    public User clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error("clone not supported");
        }
    }
}
