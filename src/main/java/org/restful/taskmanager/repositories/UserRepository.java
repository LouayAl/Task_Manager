package org.restful.taskmanager.repositories;

import org.restful.taskmanager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByname(String username);
    User findByemail(String email);
}
