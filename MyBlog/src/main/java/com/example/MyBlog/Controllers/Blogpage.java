package com.example.MyBlog.Controllers;


import com.example.MyBlog.Component.Blog;
import com.example.MyBlog.Component.UserProfile;
import com.example.MyBlog.Repositorys.BLogRepos;
import com.example.MyBlog.Repositorys.UserProfileRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;

@SessionAttributes("prf")
@Controller
public class Blogpage {

    @Autowired
    UserProfileRepos userProfileRepos;

    @Autowired
    BLogRepos bLogRepos;

    @GetMapping("/addBlog/{id}")
    public String addBlog(@SessionAttribute("prf") UserProfile profile, Model model){
        model.addAttribute("prf",profile);
        return "blogcreate_page";
    }


    @PostMapping("/addBlog/checkBlog")
    public String checknewBlog(@SessionAttribute("prf") UserProfile profile, Model model, @RequestParam String name, @RequestParam String content, @RequestParam MultipartFile image) throws IOException {

        Blog blog = new Blog(name, image.getBytes(), content,profile);
        profile.addB(blog);
        bLogRepos.save(blog);

        userProfileRepos.save(profile);

        Loginpage.profileSetter(profile,model);


        return "profile_page";
    }

   @GetMapping("/blog")
   public String getBlog(Model model,@RequestParam int id){

        Blog blog = bLogRepos.findById(id).get();
        model.addAttribute("blgimg",Base64.getEncoder().encodeToString(blog.getImage()));
        model.addAttribute("blgnm",blog.getName());
        model.addAttribute("blgcnt",blog.getContent());


       return "blog_page";
   }


}
