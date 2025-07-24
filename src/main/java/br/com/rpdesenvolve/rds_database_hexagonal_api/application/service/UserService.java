package br.com.rpdesenvolve.rds_database_hexagonal_api.application.service;

import br.com.rpdesenvolve.rds_database_hexagonal_api.domain.model.User;
import br.com.rpdesenvolve.rds_database_hexagonal_api.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
