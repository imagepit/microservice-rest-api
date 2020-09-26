package com.microservice.user.application.user;

import java.io.Serializable;


/**
 * REST APIのJSONのデータ構造として定義
 *  ドメインモデル層のエンティティをそのままAPIのデータ構造にはしない
 *      -> ドメインモデルは常に深化させるべきものなので
 */
public class UserDTO
        implements Serializable
{
    //---------------------
    // フィールド
    //---------------------
    private String id;
    private String name;
    private String password;
    //---------------------
    // ゲッター・セッター
    //---------------------
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
