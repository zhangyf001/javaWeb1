package com.zyf.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("login")
public class LoginController {
    @RequestMapping("/isOK")
    public String login(String userName, String password, Model model, HttpServletRequest request){
        String name = userName;
        String pwd = password;
//        Long token = System.currentTimeMillis();
//        request.getSession().setAttribute("token",token);
        model.addAttribute("name", name);
        model.addAttribute("pwd", pwd);
        return "index";
    }
}
