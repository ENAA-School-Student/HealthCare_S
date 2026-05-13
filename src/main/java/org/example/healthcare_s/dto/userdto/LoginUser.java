package org.example.healthcare_s.dto.userdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LoginUser {
    private String email;
    private String password;
}
