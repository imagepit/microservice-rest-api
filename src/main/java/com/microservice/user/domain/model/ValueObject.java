package com.microservice.user.domain.model;

/**
 * 値オブジェクトインターフェース
 */
public interface ValueObject {
    boolean equals(Object that); // 値オブジェクトの等価性
    int hashCode(); // 値オブジェクトの等価性
}
