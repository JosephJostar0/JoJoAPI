package com.zuel.jojo_interface.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("rand")
public class RandController {
    private final Random random = new Random();
    private final String[] MAIL_LIST = {
            "gmail", "outlook", "yahoo", "icloud", "aol",
            "qq", "163", "126", "foxmail", "hotmail",
    };

    private String generateRandString(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            sb.append(c);
        }
        return sb.toString();
    }

    private String generateRandString() {
        int randLen = random.nextInt(6, 16);
        return generateRandString(randLen);
    }

    private String generateRandTail() {
        return "@" + MAIL_LIST[random.nextInt(MAIL_LIST.length)] + ".com";
    }

    @GetMapping("/getMail")
    public String getRandMail() {
        return generateRandString() + generateRandTail();
    }

    @PostMapping("/postMail")
    public String postRandMail() {
        return generateRandString() + generateRandTail();
    }
}
