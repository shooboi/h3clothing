package net.aptech.h3clothing.service.serviceImpl;

import net.aptech.h3clothing.dto.BlogDTO;
import net.aptech.h3clothing.entity.Blog;
import net.aptech.h3clothing.repository.BlogRepository;
import net.aptech.h3clothing.repository.UserInf_Repository;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.UserInfoService;
import net.aptech.h3clothing.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BlogBusImpl implements GenericService<BlogDTO> {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    UserInf_Repository userInf_repository;
    @Autowired
    Utility utility;

    @Override
    public List<BlogDTO> getAll() {
        return utility.convertBlogDTOFromBlogs(blogRepository.findAll());
    }

    @Override
    public BlogDTO save(BlogDTO blogDTO) {
        Blog blog = blogRepository.save(utility.convertBlogFromBlogDTO(blogDTO));
        return new BlogDTO(blog.getTitle(),
                blog.getDescription(),
                blog.getUser(),
                blog.isPublished(),
                blog.getCreatedAt(),
                blog.getUpdatedAt());
    }

    @Override
    public Optional<BlogDTO> getById(int id) {
        return Optional.of(utility.convertBlogDTOFromBlog(blogRepository.getById(id)));
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }

}
