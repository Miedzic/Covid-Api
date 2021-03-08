package com.example.SpringFirstProject.authorization;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
 class UserRequest {
    private String login;
    private String passwd;

}
