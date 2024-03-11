package com.zuel.jojo_interface.controller;

import com.zuel.jojoapi_client_sdk.model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("name")
public class NameController {
    @GetMapping("/")
    public String getNameByGet(String name) {
        return "GET Your name is " + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name) {
        return "POST Your name is " + name;
    }

    @PostMapping("/user/")
    public String getUserNameByPost(@RequestBody User user, HttpServletRequest request) {
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String body = request.getHeader("body");

        if (!accessKey.equals("")) {
            throw new RuntimeException("access denied");
        }

        if (Long.parseLong(nonce) > 10000) {
            throw new RuntimeException("access denied");
        }

        return "POST User.name is " + user.getUsername();
    }
}
