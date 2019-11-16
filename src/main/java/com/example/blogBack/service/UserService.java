package com.example.blogBack.service;

import com.example.blogBack.models.blog;
import com.example.blogBack.models.user;
import com.example.blogBack.repository.BlogRepository;
import com.example.blogBack.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    private UserRepository u;
@Autowired
private BlogRepository blogRepository;
    public Optional<user> CurrentUser(Principal principal) {
        String username = principal.getName();
        return u.findByUsername(username);
    }

    public Long getUserId(Principal principal) {
        String username = principal.getName();
        Long id = u.findByUsername(username).get().getUserId();
        return id;
    }

    public Optional<user> getUserProfile(Principal principal)
    {
        return u.findByUsername(principal.getName());
    }
    public blog addblog(blog b, Long userid)
    {
        user us=u.findByUserId(userid);
        b.setUsers(us);
        return blogRepository.save(b);
    }
}
