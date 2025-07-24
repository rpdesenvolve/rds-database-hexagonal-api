package br.com.rpdesenvolve.rds_database_hexagonal_api.infrastructure.repository;

import br.com.rpdesenvolve.rds_database_hexagonal_api.domain.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);
    List<User> findAll();
}
