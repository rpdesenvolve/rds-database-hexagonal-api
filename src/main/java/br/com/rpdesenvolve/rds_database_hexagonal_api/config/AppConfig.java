package br.com.rpdesenvolve.rds_database_hexagonal_api.config;

import br.com.rpdesenvolve.rds_database_hexagonal_api.adapters.output.UserRepositoryAdapter;
import br.com.rpdesenvolve.rds_database_hexagonal_api.domain.port.UserRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserRepositoryPort userRepositoryPort(UserRepositoryAdapter adapter) {
        return adapter;
    }
}
