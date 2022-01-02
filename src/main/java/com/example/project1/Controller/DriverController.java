package com.example.project1.Controller;

import com.example.project1.Services.DriverService;
import com.example.project1.model.Driver;
import org.springframework.web.bind.annotation.*;

@RestController
public class DriverController {
    private DriverService driverService;

    @GetMapping("driver/{username}/{password}}")
    public boolean login(@PathVariable("username") String username, @PathVariable("password") String pasword) {
        return driverService.login(username, pasword);
    }

    @PostMapping("/driver/signup")
    public Driver Signup(@RequestBody Driver u) {
        return driverService.signUp(u);
    }

    @PostMapping("driver/addfavorite/{area}")
    public void addFavoriteArea(@PathVariable("area") String area) {
        driverService.addFavoriteArea(area);
    }

    @PostMapping("driver/{numOfRequest}/{price}")
    public void selectRequest(@PathVariable("numOfRequest") int numOfRequest, @PathVariable("price") int price) {
        driverService.selectRequest(numOfRequest, price);
    }

    @GetMapping("driver/selectRequest")
    public String showSelectRequest() {
        return driverService.showSelectedRequest();
    }


}
