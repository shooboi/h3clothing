package net.aptech.h3clothing.controller;

import net.aptech.h3clothing.dto.BlogDTO;
import net.aptech.h3clothing.dto.UserDTO;
import net.aptech.h3clothing.dto.UserInfDTO;
import net.aptech.h3clothing.entity.User;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.UserInfoService;
import net.aptech.h3clothing.service.serviceImpl.BlogBusImpl;
import net.aptech.h3clothing.service.serviceImpl.UserInfServiceImpl;
import net.aptech.h3clothing.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
    final GenericService<BlogDTO> service;
    final GenericService<UserDTO> userService;
    final GenericService<UserInfDTO> userInfoService;

    @Autowired
    UserInfoService userInfService;

    public BlogController(BlogBusImpl service, UserServiceImpl userService, UserInfServiceImpl userInfoService){
        this.service = service;
        this.userService = userService;
        this.userInfoService = userInfoService;
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<?> createBlog(@RequestBody BlogDTO blogRequest, Authentication authentication) {
        try {
            User user = (User) authentication.getPrincipal();
            UserInfDTO user_info = userInfService.getUserInfoByUserId(user.getUserId());
            blogRequest.setUser(user_info);
            blogRequest.setCreatedAt(Instant.now());
            blogRequest.setUpdatedAt(Instant.now());
            service.save(blogRequest);
            return new ResponseEntity<>(blogRequest, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateBlog(@RequestBody BlogDTO blogRequest, @PathVariable("id") Integer id, Authentication authentication) {
        try {
            User user = (User) authentication.getPrincipal();
//            UserInfDTO user_info = userInfService.getUserInfoByUserId(user.getUserId());
            BlogDTO find = extractBlogFromId(id, blogRequest);

            return new ResponseEntity<>(find, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    public BlogDTO extractBlogFromId(Integer id, BlogDTO dto){
        BlogDTO blog = service.getById(id).get();
        blog.setTitle(dto.getTitle());
        blog.setDescription(dto.getDescription());
        blog.setPublished(dto.isPublished());
        blog.setUpdatedAt(Instant.now());
        service.save(blog);
        return blog;
    }
}
