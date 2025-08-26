package com.example.hompass_compliance.controller;

import com.example.hompass_compliance.dto.ChoiceForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.*;

@Controller
public class indexController {

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
        System.out.println(form.toString());
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
        System.out.println(form.toString());
        model.addAttribute("isCheck", true);

        return "page/check";
    }

}



