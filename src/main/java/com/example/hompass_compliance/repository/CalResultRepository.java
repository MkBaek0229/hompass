package com.example.hompass_compliance.repository;

import com.example.hompass_compliance.entity.CalResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

public interface CalResultRepository extends JpaRepository<CalResult, Long> {
    // 특정 유저의 모든 결과 조회
    @Query(value = "SELECT * FROM CAL_RESULT WHERE USERS_ID = :usersId;", nativeQuery = true)
    ArrayList<CalResult> findByUsersId(@PathVariable("usersId") Long usersId);

    @Override
    ArrayList<CalResult> findAll();

//    List<CalResult> findByUsers_Id(Long usersId);
}
