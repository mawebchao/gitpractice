package com.project.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    public String getEncodesPwssword(String rawPassword){
        return new BCryptPasswordEncoder().encode(rawPassword);
    }
}
