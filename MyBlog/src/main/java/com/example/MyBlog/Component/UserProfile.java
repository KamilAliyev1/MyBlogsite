package com.example.MyBlog.Component;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;

    String name;

    int blognumber=0;

    int followersnumber=0;

    int followingnumber=0;

    @OneToMany(targetEntity = Blog.class)
    List<Blog> Blogs = new ArrayList<>();

    public UserProfile() {
    }

    public UserProfile(int id, String name, int blognumber, int followersnumber, int followingnumber, List<Blog> blogs) {
        this.id = id;
        this.name = name;
        this.blognumber = blognumber;
        this.followersnumber = followersnumber;
        this.followingnumber = followingnumber;
        Blogs = blogs;
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

    public int getBlognumber() {
        return blognumber;
    }

    public void setBlognumber(int blognumber) {
        this.blognumber = blognumber;
    }

    public int getFollowersnumber() {
        return followersnumber;
    }

    public void setFollowersnumber(int followersnumber) {
        this.followersnumber = followersnumber;
    }

    public int getFollowingnumber() {
        return followingnumber;
    }

    public void setFollowingnumber(int followingnumber) {
        this.followingnumber = followingnumber;
    }

    public List<Blog> getBlogs() {
        return Blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        Blogs = blogs;
    }

    public void addB(Blog b){
        Blogs.add(b);
        blognumber=Blogs.size();
    }

}


