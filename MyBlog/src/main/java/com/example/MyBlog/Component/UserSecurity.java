package com.example.MyBlog.Component;


import javax.persistence.*;


@Entity
public class UserSecurity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;

    String name;

    String email;

    String password;


    @OneToOne(targetEntity = User.class,cascade = {CascadeType.ALL})
    User user;

    public UserSecurity() {
    }

    public UserSecurity(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
