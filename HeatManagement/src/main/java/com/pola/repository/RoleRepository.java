package com.pola.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pola.models.ERole;
import com.pola.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
