package com.example.MyBlog.Component;

import javax.persistence.*;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;

    @OneToOne(targetEntity = UserProfile.class,cascade = {CascadeType.ALL})
    UserProfile userProfile;


    @OneToOne(targetEntity = UserSecurity.class,cascade = {CascadeType.ALL})
    UserSecurity userSecurity;

    public User() {
    }

    public User(int id, UserProfile userProfile, UserSecurity userSecurity) {
        this.id = id;
        this.userProfile = userProfile;
        this.userSecurity = userSecurity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public UserSecurity getUserSecurity() {
        return userSecurity;
    }
    public void setUserSecurity(UserSecurity userSecurity) {
        this.userSecurity = userSecurity;
    }
}


