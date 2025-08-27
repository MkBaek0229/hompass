package com.example.hompass_compliance.controller;

import com.example.hompass_compliance.dto.ChoiceForm;
import com.example.hompass_compliance.entity.Question;
import com.example.hompass_compliance.entity.Topic;
import com.example.hompass_compliance.entity.Users;
import com.example.hompass_compliance.repository.QuestionRepository;
import com.example.hompass_compliance.repository.TopicRepository;
import com.example.hompass_compliance.repository.UsersRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    private TopicRepository topicRepository;

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


    @PostMapping("/choice/decide")
    public String choiceDicide(ChoiceForm form, RedirectAttributes redirectAttributes){
        log.info(form.toString());
        form.setNickname(createRandomNickname());
        // 1. DTO를 엔터티로 변환
        Users user= form.toEntity();
        log.info(user.toString());
        // 2. 리파지터리로 엔터티를 DB에 저장
        Users saved = userRepository.save(user);
        log.info(saved.toString());

        System.out.println(saved.getIs_age());
        return "redirect:/check";
    }

    @GetMapping("/check")
    public String check(Model model) {

    // 3. 질문 테이블의 모든 데이터 가져오기
    ArrayList<Question> questionEntityList = questionRepository.findAll();

            System.out.println(questionEntityList);
    // 4. 지금 질문 테이블의 모든데이터에서 id값들만 따로 추출.

    ArrayList<Integer> topic_id_list = new ArrayList<>(8);
        for(Question i : questionEntityList) {

        if(topic_id_list.contains(i.getTopic_id())) {
            continue;
        }
        else {
            topic_id_list.add(i.getTopic_id());
        }
    }

    ArrayList<Topic> topic_list = new ArrayList<>(8);

    // 5. 아이디 값에 따른 name을 모델 데이터에 등록해서 뷰에뿌림.
        for(Integer i : topic_id_list) {

        Topic topicEntity = topicRepository.findAllById(i).orElse(null);

        System.out.println(topicEntity);
        topic_list.add(topicEntity);


    }

        System.out.println(topic_list);

    // 6. 모델에 데이터 등록하기
        model.addAttribute("isCheck", true);
        model.addAttribute("topicList",topic_list);
        return "page/check";
    }

    @GetMapping("/check/{id}")
    public String show(@PathVariable Long id, Model model) {
        // 1. 질문 테이블 데이터 모두 가져오기.
        ArrayList<Question> questionEntityList = questionRepository.findAll();
        // 2. 질문 테이블 데이터 반복문 돌리면서. topic_id값과 매개변수로 받은 id값이 일치하는 데이터만 일단 arraylist에 담을것?
        ArrayList<Question> question_list = new ArrayList<>(8);
        if(question_list.isEmpty()) {
            for (Question i : questionEntityList) {
                Long topic_id = (long) i.getTopic_id();
                if (topic_id.equals(id)) {
                    question_list.add(i);
                }

            }
        } else {
            question_list.clear();
        }

        System.out.println("question_list : "+ question_list);
        System.out.println("-----------------------------------------");


//        // 1. id를 조회해 데이터 가져오기.
        Question questionEntity = questionRepository.findById(id).orElse(null);
        System.out.println(questionEntity);
//        // 2. 모델에 데이터 등록하기

        model.addAttribute("questionList",question_list);

        return "page/test";
    }


}



