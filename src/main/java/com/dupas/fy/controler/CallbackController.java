package com.dupas.fy.controler;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/callback")
public class CallbackController {


    @GetMapping
    public String helloWorld() {
        // return helloWorldService.helloWorld("Daniel");
        return "Callback realizado";
    }

}
