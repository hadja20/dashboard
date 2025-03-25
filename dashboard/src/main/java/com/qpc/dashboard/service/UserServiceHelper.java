package com.qpc.dashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qpc.dashboard.models.User;
import com.qpc.dashboard.repository.UserRepository;

@Service
public class UserServiceHelper implements UserService{

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);        
    }
}