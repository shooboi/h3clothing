package net.aptech.h3clothing.controller;

import net.aptech.h3clothing.dto.BlogDTO;
import net.aptech.h3clothing.dto.RoleDTO;
import net.aptech.h3clothing.dto.UserDTO;
import net.aptech.h3clothing.dto.UserInfDTO;
import net.aptech.h3clothing.entity.Role;
import net.aptech.h3clothing.entity.User_Info;
import net.aptech.h3clothing.security.CustomerUserDetail;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.UserInfoService;
import net.aptech.h3clothing.service.serviceImpl.BlogBusImpl;
import net.aptech.h3clothing.service.serviceImpl.RoleServiceImpl;
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

    @PreAuthorize("hasAnyAuthority('ADMIN', 'BLOG')")
    @PostMapping("/add")
    public ResponseEntity<?> createBlog(@RequestBody BlogDTO blogRequest, Authentication authentication) {
        if (authentication == null) return new ResponseEntity<>("No legit login authentication found", HttpStatus.NO_CONTENT);
        try {
            CustomerUserDetail user = (CustomerUserDetail) authentication.getPrincipal();
            User_Info user_info = userInfService.getUserInfoByUserId(user.getUser().getId());

            blogRequest.setUserInfo(user_info);
            blogRequest.setCreatedAt(Instant.now());
            blogRequest.setUpdatedAt(Instant.now());
            service.save(blogRequest);
            return new ResponseEntity<>(blogRequest, HttpStatus.CREATED);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'BLOG')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateBlog(@RequestBody BlogDTO blogRequest, @PathVariable("id") Integer id, Authentication authentication) {
        if (authentication == null) return new ResponseEntity<>("No legit login authentication found", HttpStatus.NO_CONTENT);
        try {
            CustomerUserDetail user = (CustomerUserDetail) authentication.getPrincipal();

            if (user.getUser().getRoleSet().stream().noneMatch(role -> role.getRoleName().equals("ADMIN"))){
                User_Info user_info = userInfService.getUserInfoByUserId(user.getUser().getId());
                if (user_info.getId() != service.getById(id).get().getUserInfo().getId())
                    return new ResponseEntity<>("You are not allowed to edit blogs of other users", HttpStatus.UNAUTHORIZED);
            }
            BlogDTO find = extractBlogFromId(id, blogRequest);
            return new ResponseEntity<>(find, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        BlogDTO dto = service.getById(id).get();
        return ResponseEntity.ok(dto);
    }
    @PreAuthorize("hasAnyAuthority('ADMIN', 'BLOG')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id, Authentication authentication) {
        if (authentication == null) return new ResponseEntity<>("No legit login authentication found", HttpStatus.NO_CONTENT);
        try {
            CustomerUserDetail user = (CustomerUserDetail) authentication.getPrincipal();
            if (user.getUser().getRoleSet().stream().noneMatch(role -> role.getRoleName().equals("ADMIN"))){
                User_Info user_info = userInfService.getUserInfoByUserId(user.getUser().getId());
                if (user_info.getId() != service.getById(id).get().getUserInfo().getId())
                    return new ResponseEntity<>("Can't delete. You are not the original poster of this blog", HttpStatus.UNAUTHORIZED);
            }
            service.remove(id);
            return ResponseEntity.ok("Deleted");
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
