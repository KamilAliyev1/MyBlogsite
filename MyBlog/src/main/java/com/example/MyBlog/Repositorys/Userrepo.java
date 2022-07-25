package com.example.MyBlog.Repositorys;

import com.example.MyBlog.Component.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepo extends CrudRepository<User,Integer> {
}
