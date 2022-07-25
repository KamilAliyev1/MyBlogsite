package com.example.MyBlog.Controllers;

import com.example.MyBlog.Component.Blog;
import com.example.MyBlog.Component.UserProfile;
import com.example.MyBlog.Repositorys.BLogRepos;
import com.example.MyBlog.Repositorys.UserProfileRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class Firtspage {

    @Autowired
    UserProfileRepos userProfileRepos;

    @Autowired
    BLogRepos bLogRepos;

    @GetMapping("/")
    public String greeting() throws IOException {
        return "login_page";
    }


}
