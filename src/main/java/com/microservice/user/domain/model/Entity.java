package com.microservice.user.domain.model;

/**
 * エンティティインターフェース
 * エンティティとは
 *  識別子が必要でライフサイクルを管理したいもの
 *      ユーザ、商品、注文、契約とか
 * @param <T>
 */
public interface Entity<T extends Entity<T>> extends Cloneable {
    boolean equals(Object that);
    int hashCode();
    T clone();
}
