package com.example.MyBlog.Repositorys;

import com.example.MyBlog.Component.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BLogRepos extends CrudRepository<Blog,Integer> {
}
