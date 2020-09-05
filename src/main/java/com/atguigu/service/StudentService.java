package com.atguigu.service;

import com.atguigu.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<Student> findStudents();

    public Optional<Student> findStudentById(Integer id);

    public void deleteStudentById(Integer id);

    public void updateStudent(Student student);

    public void saveStudent(Student student);
}
