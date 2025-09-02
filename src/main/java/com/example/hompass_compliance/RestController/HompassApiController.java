package com.example.hompass_compliance.RestController;

import com.example.hompass_compliance.dto.CalResultForm;
import com.example.hompass_compliance.dto.UsersForm;
import com.example.hompass_compliance.entity.CalResult;
import com.example.hompass_compliance.entity.Users;
import com.example.hompass_compliance.service.CalResultService;
import com.example.hompass_compliance.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Random;


@RestController
public class HompassApiController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private CalResultService calResultService;


    // Get
    @GetMapping("/api/user")
    public ResponseEntity<ArrayList<UsersForm>> selectUser() {
        // 서비스에 위임
        ArrayList<UsersForm> dtos = usersService.users();
        System.out.println(dtos);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    // POST
    @PostMapping("/api/user")
    public ResponseEntity<UsersForm> createUser(@RequestBody UsersForm dto) {
        // 어노테이션으로 유효성 검증 추가하기.
        // 서비스에 위임
        UsersForm usersForm = usersService.create(dto);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(usersForm);
    }

    // Get
    @GetMapping("/api/user/{userId}/user_result")
    public ResponseEntity<ArrayList<CalResultForm>> selectCalResult(@PathVariable("userId") Long usersId) {
        ArrayList<CalResultForm> cdtos = calResultService.result(usersId);
        return ResponseEntity.status(HttpStatus.OK).body(cdtos);

    }
}

