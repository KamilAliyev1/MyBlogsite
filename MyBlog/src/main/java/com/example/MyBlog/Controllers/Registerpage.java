package com.example.MyBlog.Controllers;

import com.example.MyBlog.Repositorys.UserProfileRepos;
import com.example.MyBlog.Repositorys.UserSecurityRepos;
import com.example.MyBlog.Repositorys.Userrepo;
import com.example.MyBlog.Component.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Controller
public class Registerpage {
    @Autowired
    UserSecurityRepos userSecurityRepos;

    @Autowired
    UserProfileRepos userProfileRepos;

    @Autowired
    Userrepo userrepo;

    @PostMapping("/login")
    public String postRegister(@RequestParam String firstname, @RequestParam String email, @RequestParam String password) throws IOException {

        List<UserSecurity> userSecurities =  (List<UserSecurity>) userSecurityRepos.findAll();
        if(chekEmailConculution(userSecurities,email)){
            return "yanlis email ve ya password";
        }
        UserSecurity userSecurity = new UserSecurity(firstname,email,password);

        UserProfile userProfile = new UserProfile();

        User user = new User();

        userProfile.setName(userSecurity.getName());
        userSecurity.setUser(user);
        user.setUserProfile(userProfile);
        user.setUserSecurity(userSecurity);

        userSecurityRepos.save(userSecurity);
        userProfileRepos.save(userProfile);
        userrepo.save(user);


        return "login_page";
    }


    @GetMapping("/register")
    public String postLogin(){
        return "register_page";
    }
    private boolean chekEmailConculution(List<UserSecurity> userSecurities,String email){
        for (UserSecurity security:userSecurities) {
            if(security.getEmail().equals(email)) return true;
        }
        return false;
    }



}
