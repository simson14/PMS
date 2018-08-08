package com.widetns.framework.mvc.system.member;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class LoginController {

    @GetMapping("/loginform")
    public String loginForm() {
        return "LoginView";
    }
}
