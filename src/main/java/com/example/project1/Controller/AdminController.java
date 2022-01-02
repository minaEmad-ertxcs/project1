package com.example.project1.Controller;

import com.example.project1.Services.AdminService;
import com.example.project1.Services.DriverService;
import com.example.project1.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("admin/{username}/{password}")
    public boolean login(@PathVariable("username") String username, @PathVariable("password") String pasword) {
        return adminService.login(username, pasword);
    }

    @PostMapping("admin/{index}")
    public void selectDriver(@PathVariable("index") int index) {
        adminService.selectDriver(index);
    }

    @GetMapping("admin/listDrivers")
    public ArrayList<String> listPendingDriverRegistrations() {
        return adminService.listPendingDriverRegistrations();
    }

    @PostMapping("admin/suspendUser/")
    public void suspendUser(@RequestBody UserService u) {
        adminService.suspendUser(u);
    }

    @PostMapping("admin/suspendDriver/")
    public void suspendDriver(@RequestBody DriverService d) {
        adminService.suspendDriver(d);
    }

    @GetMapping("admin/showListSuspended")
    public ArrayList<String> showListOfSuspended() {
        return adminService.showListOfSuspended();
    }

}
