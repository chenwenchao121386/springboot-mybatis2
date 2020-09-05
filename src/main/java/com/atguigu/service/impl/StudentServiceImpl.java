package com.atguigu.service.impl;

import com.atguigu.dao.StudentDao;
import com.atguigu.domain.Student;
import com.atguigu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public List<Student> findStudents() {


        String key = "allstudents";
        List<Student> students = (List<Student>) redisTemplate.boundValueOps(key).get();
        System.out.println(students);
//        List<Student> students = (List<Student>) redisTemplate.boundValueOps(key).getKey();
        if (students != null) {
            System.out.println("从缓存中取的数据=="+students);
            return students;
        }
        students=studentDao.findAll();
        if (students != null) {
            System.out.println("从数据库中取得数据，放到redis缓存中"+students);
            redisTemplate.boundValueOps(key).set(students);
        }
        return students;
    }

    @Override
    public Optional<Student> findStudentById(Integer id) {
        return  studentDao.findById(id);
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentDao.deleteById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.save(student);
    }

    @Override
    public void saveStudent(Student student) {
        studentDao.save(student);
    }
}
