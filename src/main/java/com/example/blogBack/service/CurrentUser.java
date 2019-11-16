package com.example.blogBack.service;

import com.example.blogBack.models.blog;
import com.example.blogBack.models.user;
import com.example.blogBack.repository.BlogRepository;
import com.example.blogBack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class CurrentUser
{
    @Autowired
    UserRepository userRepository;
    @Autowired
    BlogRepository blogRepository;
    public user getProfile(Principal principal){
        Optional<user> myp=userRepository.findByUsername(principal.getName());
        return myp.get();
    }
    public List<blog> getBlogByUserid(Long id){
        user u= userRepository.findByUserId(id);
        return blogRepository.findByUsers(u);
    }

//    public Long getUserId(Principal principal) {
//        Optional<user> myp=userRepository.findByUsername(principal.getName());
//        return myp.get();
//    }
}
