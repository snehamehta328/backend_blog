package com.example.blogBack.controller;

import com.example.blogBack.exception.ResourceNotFoundException;
import com.example.blogBack.models.blog;
import com.example.blogBack.models.user;
import com.example.blogBack.repository.BlogRepository;
import com.example.blogBack.repository.UserRepository;
import com.example.blogBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200" , methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RestController
@RequestMapping("/api")
public class BlogController
{
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @RequestMapping(value="/blogdetails", method = RequestMethod.GET)
    @ResponseBody
//    @GetMapping("/blogdetails")
    public List<blog> getAlldetails()
    {
        return blogRepository.findAll();
    }

    @RequestMapping(value="/insert", method = RequestMethod.POST)
    @ResponseBody
//    @PostMapping("/insert")
    public blog createNewBlog(@Valid @RequestBody blog ifc)
    {
        return blogRepository.save(ifc);
    }

    @RequestMapping(value="/addblog", method = RequestMethod.POST)
    @ResponseBody
//@PostMapping("/addblog")
public blog addblog(@RequestBody blog b, Principal principal)
{
    return userService.addblog(b, userService.getUserId(principal));
}

    @RequestMapping(value="/del/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        blog abc =  blogRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        blogRepository.delete(abc);

        return ResponseEntity.ok().build();
    }
    @RequestMapping(value="/par/{blog_id}", method = RequestMethod.GET)
    @ResponseBody
    public blog getDetailsById(@PathVariable(value="blog_id") Long blogId)
    {
        return blogRepository.findById(blogId).orElseThrow(() -> new ResourceNotFoundException("Details", "product_id", blogId));
    }
    @RequestMapping(value="/getProductsByCategory/{category}", method = RequestMethod.GET)
    @ResponseBody
//    @GetMapping("/getProductsByCategory/{category}")
    public List<blog> getProductsByCategory(@PathVariable(value="category")String product_category)
    {
        return blogRepository.findAllByCategory(product_category);
    }

//    @RequestMapping(value="/blo/{id}", method = RequestMethod.PUT)
//    @ResponseBody
    @PutMapping("/blo/{id}")
    public blog updateNote(@PathVariable(value = "id") Long noteId,
                               @Valid @RequestBody blog noteDetails) {
        blog note = blogRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
        note.setName(noteDetails.getName());
//    note.setProductId(noteDetails.getProductId());
        note.setCategory(noteDetails.getCategory());
        note.setContent(noteDetails.getContent());
        note.setImage(noteDetails.getImage());
        note.setActive(noteDetails.getActive());
        blog updatedNote = blogRepository.save(note);
        return updatedNote;
    }
//@RequestMapping(value="/blo/{id}", method = RequestMethod.PUT)
//@ResponseBody
//    public blog update(@PathVariable(value = "id") blog b  @Valid @RequestBody )
//    {
//        Long blogid=b.getBlogId();
//        blog blog=blogRepository.findByBlogId(blogid);
//        System.out.println(blog);
//        blog.setActive(b.getActive());
//        blog.setCategory(b.getCategory());
//        blog.setContent(b.getContent());
//        blog.setImage(b.getImage());
//        blog.setName(b.getName());
//        return blogRepository.save(blog);
//    }

}

