package com.example.MyBlog.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Blogtymeleaf implements Serializable {
    int id;
    String name;
    String img;

    public Blogtymeleaf(int id, String name, String img) {
        this.id = id;
        this.name = name;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
