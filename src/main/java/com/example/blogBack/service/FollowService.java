package com.example.blogBack.service;

import com.example.blogBack.models.blog;
import com.example.blogBack.models.follower;
import com.example.blogBack.models.user;
import com.example.blogBack.repository.BlogRepository;
import com.example.blogBack.repository.FollowRepository;
import com.example.blogBack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;

@Service
public class FollowService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    FollowRepository followRepository;
    public List<blog> follow(Long id, Long id2, Principal principal)
    {
        user u=userRepository.findByUserId(id);
        user u2=userRepository.findByUserId(id2);
        List<blog> blogList=blogRepository.findByUsers(u);
        follower follow =new follower(u, u2);
        followRepository.save(follow);
        return blogList;

    }
    @Transactional
    public List<follower> unfollowed(Long id, Long id2, Principal principal)
    {
        follower follow=followRepository.findFollowersByFollowerid(id);
        followRepository.delete(follow);

        user u2=userRepository.findByUserId(id2);

      return followRepository.findAllByUser2(u2);
    }
    public List<follower> lis(Long user_id,Principal principal)
    {
        user u=userRepository.findByUserId(user_id);
        return followRepository.findAllByUser2(u);
    }
    public List<follower> listt(Long user_id,Principal principal)
    {
        user u=userRepository.findByUserId(user_id);
        return followRepository.findAllByUser1(u);
    }
    public List<follower> myfollowers(Long userid,Principal principal)
    {
        List<follower> followerList=followRepository.findAllByUser1_UserId(userid);
        return followerList;
    }
}

