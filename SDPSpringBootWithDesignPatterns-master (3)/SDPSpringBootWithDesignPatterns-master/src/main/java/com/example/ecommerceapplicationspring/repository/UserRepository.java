package com.example.ecommerceapplicationspring.repository;

import com.example.ecommerceapplicationspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);


}

// This is a Repository pattern
// The repository pattern is a design pattern that isolates the data layer from the rest of the app