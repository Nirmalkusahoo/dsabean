package com.nirmal.dsabean.controller;

import com.nirmal.dsabean.dto.LoginRequest;
import com.nirmal.dsabean.dto.RegisterUser;
import com.nirmal.dsabean.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody RegisterUser registerUser) {
        authService.signUp(registerUser);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {
        String token = authService.login(loginRequest);
        LoginRequest loginRes = new LoginRequest();
        loginRes.setUserName(loginRequest.getUserName());
        loginRes.setToken(token);
        return ResponseEntity.ok(loginRes);
    }
}
