package com.example.blogBack.controller;

import com.example.blogBack.exception.ResourceNotFoundException;
import com.example.blogBack.models.user;
import com.example.blogBack.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/login")
public class UserController
{
    @Autowired
    SignupRepository s;
    @GetMapping(path= "/getUser")
    public List<user> getAllUser()
    {
        return s.findAll();
    }
    @PostMapping("/addUser")
    public user createNote(@Valid @RequestBody user us)
    {
        us.setRole("user");
        us.setActive(1);
        return s.save(us);
    }
    @GetMapping("/getUsersById/{UserId}")
    public user getUserById(@PathVariable(value="UserId") Long product_id) {
        return s.findById(product_id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id",product_id));
    }
    @PutMapping("/updateById/{UserId}")
    public user updateNote(@PathVariable(value="UserId")Long noteId,
                            @Valid @RequestBody user userDetails){
        user u=s.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", noteId));
        u.setUserId(userDetails.getUserId());
        u.setPassword(userDetails.getPassword());
        u.setUsername(userDetails.getUsername());
        u.setActive(userDetails.getActive());
        u.setRole(userDetails.getRole());

        user updatedProduct= s.save(u);
        return updatedProduct;

    }
    @DeleteMapping("/users/{UserId}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value="UserId")Long product_Id)
    {
        user product=s.findById(product_Id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", product_Id));
        s.delete(product);
        return ResponseEntity.ok().build();
    }

}
