package com.rms.controller;

import com.rms.model.UserDto;
import com.rms.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("v1/admin/access-management")
public class UserController {


    private final UserService userService;

    @PostMapping("/authenticate")
    public UserDto authenticate(@RequestBody UserDto userDto) {
        log.debug("authenticate");
        userService.authenticate(userDto);
        return userDto;
    }

    @GetMapping("/allUsers")
    public List<UserDto> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        log.debug("createUser");
        return userService.createUser(userDto);
    }
}
