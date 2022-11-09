package com.example.springproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class homeController {
   @GetMapping("/")
    public String greeting() {
       return "hello here";
    }
}
