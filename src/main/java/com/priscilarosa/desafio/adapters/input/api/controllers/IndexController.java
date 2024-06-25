package com.priscilarosa.desafio.adapters.input.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class IndexController {

    @RequestMapping("/")
    public String indexController() {
        return "/index";
    }
}
