package com.example.project1.Controller;

import com.example.project1.Services.UserService;
import com.example.project1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("user/{username}/{password}}")
    public boolean login(@PathVariable("username") String username, @PathVariable("password") String pasword) {
        return userService.login(username, pasword);
    }

    @PostMapping("/user/signup")
    public User Signup(@RequestBody User u) {
        return userService.signUp(u);
    }

    @PostMapping("user/{index}/{source}/{dest}/{num}")
    public String askForRequest(@PathVariable("index") int index, @PathVariable("source") String source, @PathVariable("dest") String dest, @PathVariable("num") int numOfPeople) {
        return userService.getUserById(index).askForRequest(source, dest, numOfPeople);
    }

    @GetMapping("user/{index}")
    public String showMyRequest(@PathVariable("index") int index) {
        return userService.getUserById(index).showMyRequest();
    }

    @PostMapping("user/myc/{choice}")
    public void makeYourChoice(@PathVariable("choice") boolean choice) {
        userService.makeYourChoice(choice);
    }

    @PostMapping("user/rate/{rate}")
    public String rateDriver(@PathVariable("rate") int rate) {
        return userService.rateDriver(rate);
    }
}
