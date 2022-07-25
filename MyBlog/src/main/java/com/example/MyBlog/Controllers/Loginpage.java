package com.example.MyBlog.Controllers;


import com.example.MyBlog.Repositorys.UserSecurityRepos;
import com.example.MyBlog.Repositorys.Userrepo;

import com.example.MyBlog.Component.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;
@SessionAttributes("prf")
@Controller
public class Loginpage {
    @Autowired
    UserSecurityRepos userSecurityRepos;

    @Autowired
    Userrepo userrepo;


    @GetMapping("/user")
    public String gettLogin(UserProfile userProfile, @RequestParam String email, @RequestParam String password, Model model) throws IOException {
        List<UserSecurity> userSecurities =  (List<UserSecurity>) userSecurityRepos.findAll();
        for (UserSecurity s:userSecurities) {
            if(s.getEmail().equals(email) && s.getPassword().equals(password)) {

                userProfile = s.getUser().getUserProfile();
                Loginpage.profileSetter(userProfile,model);

                return "profile_page";
            }
        }
        return "nah";
    }


    public static List<String> byteImgConverter(List<Blog> blogs) {
        List<String> Stringimgs = new ArrayList<>();
        for (Blog blog:blogs){
            Stringimgs.add(Base64.getEncoder().encodeToString(blog.getImage()));
        }
        return Stringimgs;
    }
    public static void profileSetter(UserProfile userProfile, Model model){

        model.addAttribute("name",userProfile.getName());
        model.addAttribute("followersnumber",userProfile.getFollowersnumber());
        model.addAttribute("followingnumber",userProfile.getFollowingnumber());
        model.addAttribute("blognumber",userProfile.getBlognumber());
        model.addAttribute("prf",userProfile);

        List<Blogtymeleaf> blogtymeleafList = new ArrayList<>();

        for (Blog blog:userProfile.getBlogs()) {
            blogtymeleafList.add(new Blogtymeleaf(blog.getId(),blog.getName(),Base64.getEncoder().encodeToString(blog.getImage())));
        }

        model.addAttribute("blogtymeleafs",blogtymeleafList);


    }




}
