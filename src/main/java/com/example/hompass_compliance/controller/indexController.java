package com.example.hompass_compliance.controller;

import com.example.hompass_compliance.dto.ChoiceForm;

import com.example.hompass_compliance.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
public class indexController {


    @GetMapping({"/"})
    public String index(Model model) {
        model.addAttribute("isHome", true);
        return "home";
    }

    @GetMapping({"/user"})
    public String user(Model model){
        model.addAttribute("isUsers", true);
        return "page/user";
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
        else if(now_choice.equals("3번선택지")){
            redirect.addFlashAttribute("isChoiceMenu3", true);
        }

        redirect.addFlashAttribute("selectedMenu", now_choice);

        return "redirect:/choice";
    }


//    @PostMapping("/choice/decide")
//    public String choiceDicide(ChoiceForm form, RedirectAttributes redirectAttributes){
//        log.info(form.toString());
//        // 1. DTO를 엔터티로 변환
//        Users user= form.toEntity();
//        log.info(user.toString());
//        // 2. 리파지터리로 엔터티를 DB에 저장
//        Users saved = userRepository.save(user);
//        log.info(saved.toString());
//
//
//        return "redirect:/check";
//    }


}



