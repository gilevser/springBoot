package ru.netology.springBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springBoot.SystemProfile;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private SystemProfile profile;

    public ProfileController(SystemProfile systemProfile) {
        this.profile = systemProfile;
    }

    @GetMapping("profile")
    public String getSystemProfile() {
        return  profile.getProfile();
    }

}

//Invoke-WebRequest -Uri "http://localhost:8888/profile" -Verbose
