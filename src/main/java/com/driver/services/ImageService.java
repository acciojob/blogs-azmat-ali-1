package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Image image = new Image();
        image.setDescription(description);
        image.setDimension(dimensions);
        if(blogRepository2.findById(blogId).isPresent()){
            Blog blog = blogRepository2.findById(blogId).get();
            image.setBlog(blog);
        }
        imageRepository2.save(image);
        return image;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        if( imageRepository2.findById(id).isPresent()){
            Image image  = imageRepository2.findById(id).get();
            String dimension = image.getDimension();
            String [] sd = screenDimensions.split("x");
            String [] d  = dimension.split("x");
            int x_plane = Integer.parseInt(sd[0])/Integer.parseInt(d[0]);
            int y_plane = Integer.parseInt(sd[1])/Integer.parseInt(d[1]);
            return x_plane*y_plane;
        }
    return 0;
    }
}
