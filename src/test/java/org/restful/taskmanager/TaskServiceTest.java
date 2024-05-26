package org.restful.taskmanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.restful.taskmanager.models.Task;
import org.restful.taskmanager.repositories.TaskRepository;
import org.restful.taskmanager.services.TaskService;
import org.restful.taskmanager.models.User;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private AutoCloseable closeable;

    @BeforeEach
    public void setUp(){
        closeable = MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAllTasks(){
        User user = new User(1L, "user1", "John", "Doe", "john@example.com", "password",null,null);
        List<Task> tasks = Arrays.asList(
                new Task(1L, "task 1","Description 1", LocalDateTime.now(),LocalDateTime.now().plusDays(1),user,LocalDateTime.now(),LocalDateTime.now(),Task.Status.NOT_STARTED),
                new Task(1L, "task 2","Description 2", LocalDateTime.now(),LocalDateTime.now().plusDays(1),user,LocalDateTime.now(),LocalDateTime.now(),Task.Status.NOT_STARTED)

        );
        when(taskRepository.findAll()).thenReturn(tasks);

        //Act
        List<Task> result = taskService.findAll();

        //Assert
        assertEquals(tasks.size(), result.size());
    }

}
