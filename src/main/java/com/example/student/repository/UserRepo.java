package com.example.student.repository;

import com.example.student.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    public User findByEmailAndPassword(String email, String password);

}
