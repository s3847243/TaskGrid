package com.jobapp.jobapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jobapp.jobapp.model.JobPost;

@Controller
public class JobController {

    @GetMapping({"/","home"})
    public String home(){

        return"home";

    }
    @GetMapping("addJob")
    public String addJob(){
        return "addjob";

    }
    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost){
        return "success";
    }
    
}
