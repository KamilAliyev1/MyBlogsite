package com.example.MyBlog.Component;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    @Lob
    @Column(length =  65535)
    byte[] image;
    String content;

    @OneToOne(targetEntity = UserProfile.class)
    UserProfile user;

    public Blog() {
    }



    public Blog(String name, byte[] image, String content, UserProfile user) {
        this.name = name;
        this.image = image;
        this.content = content;
        this.user = user;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
