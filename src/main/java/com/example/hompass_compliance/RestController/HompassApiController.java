package com.example.hompass_compliance.RestController;

import com.example.hompass_compliance.dto.UsersForm;
import com.example.hompass_compliance.entity.Users;
import com.example.hompass_compliance.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
public class HompassApiController {
    @Autowired
    private UsersRepository userRepository;

    private String[] random_nickname = {"돌고래", "개발자", "오랑우탄"};


    public String createRandomNickname() {
        Random random = new Random();
        String nickname = this.random_nickname[random.nextInt(this.random_nickname.length)];
        return nickname;
    }


    // Get
    @GetMapping("/api/tdee")
    public List<Users> index() {
        return userRepository.findAll();
    }

    // POST
    @PostMapping("/api/tdee")
    public Users tdee(@RequestBody UsersForm dto) {
        dto.setNickname(createRandomNickname());
        // 1. DTO를 엔터티로 변환
        Users user = dto.toEntity();

        // 2. 리파지터리로 엔터티를 DB에 저장
        return userRepository.save(user);


    }
}
