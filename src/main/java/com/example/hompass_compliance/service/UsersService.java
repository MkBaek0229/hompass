package com.example.hompass_compliance.service;

import com.example.hompass_compliance.dto.UsersForm;
import com.example.hompass_compliance.entity.Users;
import com.example.hompass_compliance.repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class UsersService {
    private String[] random_nickname = {"돌고래", "개발자", "오랑우탄"};


    public String createRandomNickname() {
        Random random = new Random();
        String nickname = this.random_nickname[random.nextInt(this.random_nickname.length)];
        return nickname;
    }


    @Autowired
    private UsersRepository usersRepository;

    public ArrayList<UsersForm> users(){
        // 전체 조회
        ArrayList<Users> users = usersRepository.findAll();

        // 엔터티 -> dto 변환
        ArrayList<UsersForm> dos = new ArrayList<UsersForm>();
        for (int i = 0; i < users.size(); i++){
            Users c = users.get(i);
            UsersForm dto = UsersForm.createUsersForm(c);
            dos.add(dto);
        }

        // 3. 결과 반환
        return dos;
    }

    @Transactional
    public UsersForm create(UsersForm dto) {
        // 랜덤으로 사용자 닉네임 생성
        dto.setNickname(createRandomNickname());

        // 1. 유저 엔터티 생성
        Users users = Users.createUsers(dto);

        // 2. 유저 엔터티를 DB에 저장
        Users created = usersRepository.save(users);

        // 3. dto로 변환해 반환
        return UsersForm.createUsersForm(created);
    }
}
