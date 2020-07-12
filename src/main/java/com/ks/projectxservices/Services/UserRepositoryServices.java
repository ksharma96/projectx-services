package com.ks.projectxservices.Services;

import com.ks.projectxservices.Models.User;
import com.ks.projectxservices.Models.UserRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepositoryServices {

    @Autowired
    private UserRepository userRepository;

    public Boolean isExistingUser(String username) {
        List<User> userList = userRepository.findByUsername(username);

        if (userList.isEmpty()) return false;

        else return true;
    }

    public Boolean isExistingEmail(String email) {
        List<User> userList = userRepository.findByEmail(email);

        if (userList.isEmpty()) return false;

        else return true;
    }


}
