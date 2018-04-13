package com.caroline.controller;

import com.caroline.Entity.ChildUser;
import com.caroline.Entity.Result;
import com.caroline.Entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "测试登陆接口")
public class UserControllerImpl implements UserController{

    @ApiOperation(value = "登陆")
    @PostMapping("/login")
    public Result login(@RequestBody @Validated User<ChildUser> user) {
        return new Result("0", "登陆成功！");
    }
}
