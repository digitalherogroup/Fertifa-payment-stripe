package com.ithd.stripe.stripepaymentsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MainPageController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
