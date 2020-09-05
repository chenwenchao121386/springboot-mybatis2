package com.atguigu.controller;

import com.atguigu.domain.Student;
import com.atguigu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    //查询所有学生
    @RequestMapping("/findAll")
    public List<Student> findStudents(){
        return studentService.findStudents();
    }

    //根据id查询学生
    @RequestMapping("/findStudent/{id}")
    public Optional<Student> findById(@PathVariable("id") Integer id) {
        return studentService.findStudentById(id);
    }

    //添加学生
    @RequestMapping("/save")
    public void save( Student student,HttpServletRequest request,HttpServletResponse response) throws IOException {
        studentService.saveStudent(student);
        response.sendRedirect(request.getContextPath()+"/student/findAll");
    }

    //删除
    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id,HttpServletRequest request, HttpServletResponse response) throws IOException {
        studentService.deleteStudentById(id);
    }

    //更新
    @RequestMapping("/update")
    public void update(Student student,HttpServletResponse response,HttpServletRequest request) throws IOException {
        studentService.saveStudent(student);
        response.sendRedirect(request.getContextPath()+"/student/findAll");
    }
}
