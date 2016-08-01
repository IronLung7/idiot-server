package com.v.service;

import com.v.domain.AppUser;
import com.v.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhlingyu on 2016/7/29.
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public AppUser createUser(){
        System.out.println("in service");
        return userRepository.save(new AppUser("vv"));
    }
}
