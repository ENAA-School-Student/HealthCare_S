package org.example.healthcare_s.dto.userdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RegisterUser {
    private String email;
    private String username;
    private String password;
    private String role;
}
