package com.example.productcatlog.firstcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class first {
    @GetMapping("/")
    public String getmessge()
    {
        return "Welcome";
    }
}
