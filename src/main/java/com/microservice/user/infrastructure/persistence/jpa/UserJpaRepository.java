package com.microservice.user.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserJpaModel, String> {

}
