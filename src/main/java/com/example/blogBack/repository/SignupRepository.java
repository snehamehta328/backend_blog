package com.example.blogBack.repository;

import com.example.blogBack.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignupRepository extends JpaRepository<user, Long> {
    @Override
    List<user> findAll();
}
