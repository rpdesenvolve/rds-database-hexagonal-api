package br.com.rpdesenvolve.rds_database_hexagonal_api.adapters.output;

import br.com.rpdesenvolve.rds_database_hexagonal_api.domain.model.User;
import br.com.rpdesenvolve.rds_database_hexagonal_api.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryAdapter implements UserRepository {

    private final DataUserRepository dataUserRepository;

    @Autowired
    public UserRepositoryAdapter(DataUserRepository dataUserRepository) {
        this.dataUserRepository = dataUserRepository;
    }

    @Override
    public User save(User user) {
        return dataUserRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return dataUserRepository.findAll();
    }
}
