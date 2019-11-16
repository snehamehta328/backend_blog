package com.example.blogBack.controller;

import com.example.blogBack.models.blog;
import com.example.blogBack.models.follower;
import com.example.blogBack.models.user;
import com.example.blogBack.service.FollowService;
import com.example.blogBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/follower")
public class FollowController {
    @Autowired
    FollowService followService;
    @Autowired
    UserService userService;

    @GetMapping("/follow/{id}")
    public List<blog> getFollow(@PathVariable("id") Long id, Principal principal)
    {
        return followService.follow(id,userService.getUserId(principal),principal);
    }
    @GetMapping("/unfollow/{id}")
    public List<follower> unfollow(@PathVariable("id") Long id, Principal principal)
    {
       return followService.unfollowed(id,userService.getUserId(principal), principal);
    }
    @GetMapping("/allfollow")
    public List<follower> allfollow(Principal principal)
    {
        return followService.lis(userService.getUserId(principal),principal);
    }
    @GetMapping("/allfollowing")
    public List<follower> allfollowing(Principal principal)
    {
        return followService.listt(userService.getUserId(principal),principal);
    }

    @GetMapping("/myFollowers")

        public List<follower> follower(Principal principal){
            return followService.myfollowers(userService.getUserId(principal),principal);
    }
    }

