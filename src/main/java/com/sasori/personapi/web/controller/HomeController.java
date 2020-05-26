package com.sasori.personapi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class HomeController {
    private static final String REDIRECT_SWAGGER_UI_HTML = "redirect:swagger-ui.html";

    @RequestMapping("/")
    public String index() {
        return REDIRECT_SWAGGER_UI_HTML;
    }
}
