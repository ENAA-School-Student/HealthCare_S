package org.example.healthcare_s.dto.userdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RegisterUser {
    private String email;
    private String userName;
    private String password;
}
