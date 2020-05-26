package com.chan.hen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @RequestMapping("/helloWorld")
    public String test(String xx){
        return xx+":helloWorld!";
    }
}
