package com.example.blogBack.repository;

import com.example.blogBack.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<user, Long> {
    @Override
    List<user> findAll();
    Optional<user> findByUsername(String username);
    user findByUserId(Long userid);
}
