package com.example.hompass_compliance.service;

import com.example.hompass_compliance.dto.CalResultForm;
import com.example.hompass_compliance.dto.UsersForm;
import com.example.hompass_compliance.entity.CalResult;
import com.example.hompass_compliance.entity.Users;
import com.example.hompass_compliance.repository.CalResultRepository;
import com.example.hompass_compliance.repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.*;

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
    @Autowired
    private CalResultRepository calResultRepository;

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


        // 3. 하루 필요 칼로리 + 탄수화물 , 단백질, 지방 섭취량을 CalculationResult에 저장해야함.
        String man_woman = created.getMan_woman();
        double rawKcal;
        int protein;
        int carb;
        int fat;

//        int users_id = Math.toIntExact(created.getId());
        int kg = created.getKg();
        int cm = created.getCm();
        int age = created.getAge();
        float activity_level = created.getActivity_level();
        float meal_goals = created.getMeal_goals();

        if(man_woman.equals("남자")){
            rawKcal = (10 * kg) + (6.25 * cm) - (5 * age) + 5;
        } else {
            rawKcal = (10 * kg) + (6.25 * cm) - (5 * age) - 161;
        }
        rawKcal = rawKcal * activity_level * meal_goals;
        int kcal = (int)Math.round(rawKcal);

        carb = (int)Math.round(kcal * 0.3 / 4.0);
        protein = (int)Math.round(kcal * 0.5 / 4.0);
        fat = (int)Math.round(kcal * 0.2 / 9.0);


        System.out.println(kcal);
        System.out.println(protein);
        System.out.println(carb);
        System.out.println(fat);

//        // 3-1 결과 엔터티의 모든 데이터를 조회해오기. -> 가장 마지막 id를 알아 내기 위함?
//        ArrayList<CalResult> calResults = calResultRepository.findAll();
//        int size = calResults.size();
//
//        // Map에다가 담아서 보낸다
//        Map<String, Integer> r = new HashMap<>();
//
//        r.put("id", size + 1);
//        r.put("kcal",kcal);
//        r.put("protein",protein);
//        r.put("carb",carb);
//        r.put("fat",fat);
//        r.put("users_id", users_id);


//         4. 결과 엔터티 생성
        CalResult calResult = CalResult.createResult(kcal, protein, carb, fat, created);


        // 5. 결과 엔터티를 DB에 저장
         calResultRepository.save(calResult);


        // 3. dto로 변환해 반환
        return UsersForm.createUsersForm(created);
    }
}
