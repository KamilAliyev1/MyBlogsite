package com.example.MyBlog.Repositorys;

import com.example.MyBlog.Component.UserSecurity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSecurityRepos extends CrudRepository<UserSecurity,Integer> {
}
