package com.atguigu.controller;

import com.atguigu.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/thymeleaf")
public class TestThymeleafController {
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("hello", "hello Thymeleaf!");
//        Student student = new Student(1,"张飞",null,35,null,100d);
//        model.addAttribute("student", student);
        return "demo1";
    }

//    @ResponseBody
    @RequestMapping("/save")
    public String save(Integer id,String name,Double score,Model model) {
        Student student = new Student(id, name, null, null, null, score);
        System.out.println("student = " + student);
        model.addAttribute("student", student);
        return "demo2";
    }
    @ResponseBody
    @RequestMapping("/edit")
    public Student edit(/*@ModelAttribute(value = "student")*/ Student student) {
        System.out.println("student = " + student);
        return student;
    }
    @RequestMapping("/list")
    public String list(Model model){
        List<Student> list = new ArrayList<>();
        list.add(new Student(9527, "小鲤鱼泡泡", null, 5, null, 88d));
        list.add(new Student(3306, "喜羊羊", null, 6, null, 99d));
        list.add(new Student(1314, "灰太狼", null, 35, null, 96d));
        list.add(new Student(1001, "炮姐", null, 15, null, 10000d));
        model.addAttribute("studnets", list);

        Map<String, Object> map =new HashMap<>();
        map.put("city", "北京");
        map.put("date", "2020");
        map.put("address", "尚硅谷");
        model.addAttribute("map", map);


        String[] names={"克苏鲁","贞子","伽椰子","富江"};
        model.addAttribute("names", names);

        model.addAttribute("now", new Date());
        model.addAttribute("money", 100);
        return "demo3";
    }
}
