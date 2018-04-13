package com.caroline.controller;

import com.caroline.Entity.ChildUser;
import com.caroline.Entity.Result;
import com.caroline.Entity.User;
import org.springframework.web.bind.annotation.PostMapping;

public interface UserController {

    @PostMapping("/login")
    Result login(User<ChildUser> user);
}
