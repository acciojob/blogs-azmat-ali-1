package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.UserRepository;
import net.minidev.json.annotate.JsonIgnore;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);

        User user = userRepository1.findById(userId).get();
        blog.setUser(user);
        List<Blog> blogList = user.getBlogList();
        blogList.add(blog);
        user.setBlogList(blogList);
        userRepository1.save(user);

       //return dto
//        USERDTO userdto = new USERDTO();
//        userdto.setId(user.getId());
//        userdto.setUsername(user.getUsername());
//        userdto.setPassword(user.getPassword());
//        userdto.setFirstname(user.getFirstname());
//        userdto.setLastname(user.getLastname());
//
//        BLOGDTO blogdto = new BLOGDTO();
//        blogdto.setId(blog.getId());
//        blogdto.setTitle(blog.getTitle());
//        blogdto.setContent(blog.getContent());
//        blogdto.setPubDate(blog.getPubDate());
//        blogdto.setUserdto(userdto);
//        blogdto.setImageList(blog.getImageList());


        return blogRepository1.findById(blogList.size()-1).get();

    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        blogRepository1.deleteById(blogId);

    }
}
