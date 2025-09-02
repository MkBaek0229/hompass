package com.example.hompass_compliance.service;

import com.example.hompass_compliance.dto.CalResultForm;
import com.example.hompass_compliance.entity.CalResult;
import com.example.hompass_compliance.repository.CalResultRepository;
import com.example.hompass_compliance.repository.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalResultService {
    @Autowired
    private CalResultRepository calResultRepository;
    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    public ArrayList<CalResultForm> result(Long usersId) {
        // 1. 결과 조회
        ArrayList<CalResult> calResults = calResultRepository.findByUsersId(usersId);
        System.out.println(calResults);
        // 2. 엔터티 -> DTO 변환
        ArrayList<CalResultForm> dtos = new ArrayList<CalResultForm>();

        for (int i = 0; i < calResults.size(); i++) {
            CalResult c = calResults.get(i);
            CalResultForm dto = CalResultForm.createCalResultForm(c);
            dtos.add(dto);
        }
        // 3. 결과 반환
        return dtos;
    }
}
