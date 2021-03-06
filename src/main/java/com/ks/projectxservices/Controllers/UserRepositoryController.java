package com.ks.projectxservices.Controllers;

import com.ks.projectxservices.Models.User;
import com.ks.projectxservices.Models.UserRepository;
import com.ks.projectxservices.Services.UserRepositoryServices;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3200")
@RequestMapping(path = "/user")
public class UserRepositoryController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserRepositoryServices userRepositoryServices;


    @PostMapping(path = "/add")
    public @ResponseBody
    String addUser(@RequestBody String jsonBody) {
        try {
            JSONObject jsonBodyObject = new JSONObject(jsonBody);
            User user = new User();
            user.setUsername(jsonBodyObject.get("username").toString());
            user.setPassword(jsonBodyObject.get("password").toString());
            user.setEmail(jsonBodyObject.get("email").toString());
            user.setFirstname(jsonBodyObject.get("firstname").toString());
            user.setLastname(jsonBodyObject.get("lastname").toString());
//            String is_active_value = jsonBodyObject.get("is_active").toString();
//            user.setIs_active(Integer.parseInt(is_active_value));
            user.setIs_active(1);
            if (!userRepositoryServices.isExistingUser(user.getUsername()) && !userRepositoryServices.isExistingEmail(user.getEmail())) {
                userRepository.save(user);
                return "Saved";
            }
            else return "Username/Email Already Exists!";
        } catch (Exception exception) {
            return exception.getMessage();
        }

    }

    @GetMapping(path = "/allUsers")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/getUserById")
    public @ResponseBody
    List<User> getUserById(@RequestBody String userId) {
        return userRepository.findByUserid(Integer.parseInt(userId));
    }

    @PostMapping("/getUserByUsername")
    public @ResponseBody
    List<User> getUserByUsername(@RequestBody String username) {
        return userRepository.findByUsername(username);
    }

}
