package com.example.MyBlog.Repositorys;

import com.example.MyBlog.Component.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepos extends CrudRepository<UserProfile,Integer> {
}


