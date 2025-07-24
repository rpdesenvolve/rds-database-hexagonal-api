package br.com.rpdesenvolve.rds_database_hexagonal_api.config;

import br.com.rpdesenvolve.rds_database_hexagonal_api.adapters.output.UserRepositoryAdapter;
import br.com.rpdesenvolve.rds_database_hexagonal_api.infrastructure.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserRepository userRepository(UserRepositoryAdapter adapter) {
        return adapter;
    }
}
