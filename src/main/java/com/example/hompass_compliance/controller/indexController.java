package com.example.hompass_compliance.controller;

import com.example.hompass_compliance.dto.ChoiceForm;
import com.example.hompass_compliance.entity.Question;
import com.example.hompass_compliance.entity.Users;
import com.example.hompass_compliance.repository.QuestionRepository;
import com.example.hompass_compliance.repository.UsersRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Slf4j
@Controller
public class indexController {
    @Autowired
    private UsersRepository userRepository;
    @Autowired
    private QuestionRepository questionRepository;

    private String[] random_nickname = {"돌고래", "개발자", "오랑우탄"};


    public String createRandomNickname() {
        Random random = new Random();
        String nickname = this.random_nickname[random.nextInt(this.random_nickname.length)];
        return nickname;
    }

    @GetMapping({"/"})
    public String index(Model model) {
        model.addAttribute("isHome", true);
        return "home";
    }

    @GetMapping({"/choice"})
    public String choice(Model model) {
        model.addAttribute("isChoice", true);
        return "page/choice";
    }

    @PostMapping("/choice/choice_menu")
    public String choiceMenu(ChoiceForm form, RedirectAttributes redirect){
//        System.out.println(form.toString());
        log.info(form.toString());
        String now_choice = form.getOption();

        if(now_choice.equals("1번선택지"))  {
            redirect.addFlashAttribute("isChoiceMenu1", true);
        }
        else if(now_choice.equals("2번선택지")) {
            redirect.addFlashAttribute("isChoiceMenu2", true);
        }

        redirect.addFlashAttribute("selectedMenu", now_choice);

        return "redirect:/choice";
    }

    @PostMapping("/check")
    public String choiceDicide(ChoiceForm form, Model model){
//        System.out.println(form.toString());
        log.info(form.toString());
        form.setNickname(createRandomNickname());
        // 1. DTO를 엔터티로 변환
        Users user= form.toEntity();
        log.info(user.toString());
        // 2. 리파지터리로 엔터티를 DB에 저장
        Users saved = userRepository.save(user);
//        log.info(saved.toString());
//        System.out.println(saved.toString());

        System.out.println(saved.getIs_age());
        model.addAttribute("isCheck", true);

        // 3. 질문 테이블의 모든 데이터 가져오기
        ArrayList<Question> questionEntityList = questionRepository.findAll();

        System.out.println(questionEntityList);
        // 4. topic을 얻어올건데. 중복을 제거하고 얻어냄.

//        ArrayList<Map<String,Object>> topiclist = new ArrayList<>();
        ArrayList<String> topiclist = new ArrayList<>(8);
        for(Question i : questionEntityList) {

            System.out.println(i.getTopic());
            if(topiclist.contains(i.getTopic())) {
              System.out.println("이미 값이 존재합니다." + i.getTopic());
              continue;
            }
            else {
                System.out.println("값이 존재하지 않아서 값을 추가합니다"+ i.getTopic());
                topiclist.add(i.getTopic());
            }
        }

        // topiclist를 모델에 데이터로 등록하기.
        System.out.println(topiclist);

        // 4. 모델에 데이터 등록하기
        model.addAttribute("topicList", topiclist);


        return "page/check";
    }

}



