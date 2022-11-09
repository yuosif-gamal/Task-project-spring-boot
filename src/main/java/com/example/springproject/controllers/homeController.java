package com.example.springproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class homeController {
   @GetMapping("/")
    public String greeting() {
       return "hello user how are u ? ";
    }
}
