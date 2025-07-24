package br.com.rpdesenvolve.rds_database_hexagonal_api.adapters.output;

import br.com.rpdesenvolve.rds_database_hexagonal_api.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataUserRepository extends JpaRepository<User, Long> {
}
