package com.example.blogBack.repository;

import com.example.blogBack.models.blog;
import com.example.blogBack.models.follower;
import com.example.blogBack.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FollowRepository extends JpaRepository<follower, Long> {
    @Override
    List<follower> findAll();

    List<follower> findAllByUser2(user u2);
    List<follower> findAllByUser1(user u);

    Optional <user>deleteByUser1AndUser2(user u2, user u);
    List<follower> findAllByUser1_UserId(Long userid);
    follower findFollowersByFollowerid(Long id);
}
