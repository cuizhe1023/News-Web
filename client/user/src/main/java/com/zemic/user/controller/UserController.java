package com.zemic.user.controller;

import com.zemic.common.controller.BaseController;
import com.zemic.common.result.SingleResult;
import com.zemic.user.model.request.LoginRequest;
import com.zemic.user.model.response.TokenResponse;
import com.zemic.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("user")
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public SingleResult<TokenResponse> login(@Valid @RequestBody LoginRequest request, BindingResult result){
        validate(result);
        return userService.login(request);
    }
}
