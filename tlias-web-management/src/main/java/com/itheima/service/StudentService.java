package com.itheima.service;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    //分页查询
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    //删除学员
    void delete(List<Integer> ids);

    //添加学员
    void save(Student student);

    //根据ID查询学员信息
    Student getInfo(Integer id);

    //修改学员信息
    void update(Student student);

    void updateStudent(Integer id, Integer score);
}
