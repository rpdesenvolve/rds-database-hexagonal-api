package br.com.rpdesenvolve.rds_database_hexagonal_api.application.service;

import br.com.rpdesenvolve.rds_database_hexagonal_api.domain.model.User;
import br.com.rpdesenvolve.rds_database_hexagonal_api.domain.port.UserRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    private UserRepositoryPort userRepositoryPort;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepositoryPort = mock(UserRepositoryPort.class);
        userService = new UserService(userRepositoryPort);
    }

    @Test
    void shouldCreateUserSuccessfully() {
        User input = new User();
        input.setName("Ricardo");
        input.setEmail("ricardo@example.com");

        User saved = new User();
        saved.setId(1L);
        saved.setName("Ricardo");
        saved.setEmail("ricardo@example.com");

        when(userRepositoryPort.save(input)).thenReturn(saved);

        User result = userService.createUser(input);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Ricardo", result.getName());
        assertEquals("ricardo@example.com", result.getEmail());
    }

    @Test
    void shouldReturnAllUsers() {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("Ricardo");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("João");

        when(userRepositoryPort.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> users = userService.getAllUsers();

        assertEquals(2, users.size());
        assertEquals("Ricardo", users.get(0).getName());
        assertEquals("João", users.get(1).getName());
    }
}
