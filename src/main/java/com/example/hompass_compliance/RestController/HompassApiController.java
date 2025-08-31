package com.example.hompass_compliance.RestController;

import com.example.hompass_compliance.dto.UsersForm;
import com.example.hompass_compliance.entity.Users;
import com.example.hompass_compliance.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;


@RestController
public class HompassApiController {
    @Autowired
    private UsersService usersService;


    // Get
    @GetMapping("/api/user")
    public ResponseEntity<ArrayList<UsersForm>> index() {
        // 서비스에 위임
        ArrayList<UsersForm> dtos = usersService.users();
        System.out.println(dtos);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    // POST
    @PostMapping("/api/user")
    public ResponseEntity<UsersForm> create(@RequestBody UsersForm dto) {
        // 서비스에 위임
        UsersForm usersForm = usersService.create(dto);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(usersForm);
    }

}

