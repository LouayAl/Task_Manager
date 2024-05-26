package org.restful.taskmanager;


import jakarta.persistence.Table;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.restful.taskmanager.models.User;
import org.restful.taskmanager.repositories.UserRepository;
import org.restful.taskmanager.services.UserService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private AutoCloseable closeable;

    @BeforeEach
    public void setUp(){
        closeable = MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAllUsers(){
        //Arrange
        List<User> users = Arrays.asList(
                new User(1L, "User1", "Louay","ALAMI","louay.alami.ouahabi@gmail.com","password",null,null),
                new User(1L, "User1", "Louay","ALAMI","louay.alami.ouahabi@gmail.com","password",null,null)
        );
        when(userRepository.findAll()).thenReturn(users);

        //Act
        List<User> result = userService.findAll();

        //Assert
        assertEquals(users.size(), result.size());
    }

    @AfterEach
    public void tearDown() throws Exception {
        closeable.close();
    }
}
