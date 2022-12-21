package com.jpa.test.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.http.HttpRequest;

@Controller
@ResponseBody
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "h";
    }
}
