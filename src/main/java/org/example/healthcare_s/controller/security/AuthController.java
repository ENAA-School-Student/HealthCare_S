package org.example.healthcare_s.controller.security;

import lombok.RequiredArgsConstructor;
import org.example.healthcare_s.dto.userdto.AuthResponse;
import org.example.healthcare_s.dto.userdto.LoginUser;
import org.example.healthcare_s.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    @PostMapping("/login")
    public ResponseEntity<AuthResponse>login(@RequestBody LoginUser user){
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        return ResponseEntity.ok(new AuthResponse("Login successfull"));
    }

}
