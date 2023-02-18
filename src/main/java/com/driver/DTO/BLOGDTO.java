package com.driver.DTO;

import com.driver.models.Image;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BLOGDTO {
    private int id;
    private String title;
    private String content;
    private Date pubDate;
    private USERDTO userdto;
    private List<Image> imageList = new ArrayList<>();

    public BLOGDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public USERDTO getUserdto() {
        return userdto;
    }

    public void setUserdto(USERDTO userdto) {
        this.userdto = userdto;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}
