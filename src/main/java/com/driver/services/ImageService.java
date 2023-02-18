package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public void addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Image image = new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);
        if(blogRepository2.findById(blogId).isPresent()){
            Blog blog = blogRepository2.findById(blogId).get();
            image.setBlog(blog);
        }
        imageRepository2.save(image);
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        if( imageRepository2.findById(id).isPresent()){
            Image image  = imageRepository2.findById(id).get();
            String dimension = image.getDimensions();
            String [] sd = screenDimensions.split("X");
            String [] d  = dimension.split("X");
            int x_plane = Integer.parseInt(sd[0])/Integer.parseInt(d[0]);
            int y_plane = Integer.parseInt(sd[1])/Integer.parseInt(d[1]);
            return x_plane*y_plane;
        }
    return 0;
    }
}
