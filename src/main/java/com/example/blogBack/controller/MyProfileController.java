package com.example.blogBack.controller;

import com.example.blogBack.models.blog;
import com.example.blogBack.models.user;
import com.example.blogBack.repository.UserRepository;
import com.example.blogBack.service.CurrentUser;
import com.example.blogBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/profile")
public class MyProfileController {
    @Autowired
    private CurrentUser currentUser;
    @Autowired
    private UserRepository userRepository;
@Autowired
private UserService userService;
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public user getData(Principal principal) {
        return currentUser.getProfile(principal);
    }
    @RequestMapping(value = "/getCurrentUserBlog", method = RequestMethod.GET)
    @ResponseBody
    public List<blog> getCurrentUserBlog(Principal principal) {
        Long id = userService.getUserId(principal);
       return currentUser.getBlogByUserid(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public user update(@Valid @RequestBody user users) {
        users.setActive(1);
        userRepository.save(users);
        return users;

    }
}
