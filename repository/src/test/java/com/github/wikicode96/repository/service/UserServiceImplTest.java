package com.github.wikicode96.repository.service;

import com.github.wikicode96.repository.entity.User;
import com.github.wikicode96.repository.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    UserService service = new UserServiceImpl();

    @Mock
    UserRepository repository;

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
    }

    @Test
    void newUser() {
        user.setId(0);

        user = service.newUser(user);

        assertNotNull("The same User object is returned whe id = 0." , user);
    }

    @Test
    void getUserById() {
        when(repository.findById(any())).thenReturn(Optional.of(new User()));

        user = service.getUserById(1);

        assertNotNull("Return the User found if exists.", user);
    }

    @Test
    void updateUser() {
        user.setId(1);

        user = service.updateUser(user);

        assertNotNull("The same User object is returned whe is found in the db." , user);
    }

    @Test
    void deleteUser() {
        user.setId(1);

        user = service.deleteUser(user);

        assertNotNull("The same User object is returned whe is found in the db." , user);
    }
}