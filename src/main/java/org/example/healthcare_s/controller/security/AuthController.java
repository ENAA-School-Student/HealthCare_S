package org.example.healthcare_s.controller.security;

import lombok.RequiredArgsConstructor;
import org.example.healthcare_s.dto.userdto.LoginUser;
import org.example.healthcare_s.dto.userdto.RegisterUser;

import org.example.healthcare_s.service.security.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<String>register(@RequestBody RegisterUser user){
        return ResponseEntity.ok(authService.addUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String>login(@RequestBody LoginUser user){
        return ResponseEntity.ok(authService.login(user.getEmail(),user.getPassword()));
    }
 





}
