package br.com.rpdesenvolve.rds_database_hexagonal_api.domain.port;

import br.com.rpdesenvolve.rds_database_hexagonal_api.domain.model.User;

import java.util.List;

public interface UserRepositoryPort {
    User save(User user);
    List<User> findAll();
}
