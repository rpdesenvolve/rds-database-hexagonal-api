package br.com.rpdesenvolve.rds_database_hexagonal_api.application.service;

import br.com.rpdesenvolve.rds_database_hexagonal_api.domain.model.User;
import br.com.rpdesenvolve.rds_database_hexagonal_api.domain.port.UserRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    public User createUser(User user) {
        return userRepositoryPort.save(user);
    }

    public List<User> getAllUsers() {
        return userRepositoryPort.findAll();
    }
}
