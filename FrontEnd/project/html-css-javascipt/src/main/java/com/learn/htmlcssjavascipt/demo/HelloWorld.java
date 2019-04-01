package com.learn.htmlcssjavascipt.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class HelloWorld {


    @RequestMapping(path = {"/hello"},method = {RequestMethod.GET,RequestMethod.POST})
    public String HelloSpring (Model model){
        model.addAttribute("value","123");
        return "hello";
    }

    @RequestMapping(path = {"/"},method = {RequestMethod.GET,RequestMethod.POST})
    public String root (){
        System.out.println("hello root");
        return "hello root";
    }

    @RequestMapping(path = {"/psd"},method = {RequestMethod.GET,RequestMethod.POST})
    public String psd (){

        return "psdtohtmldemo/index";
    }


}
