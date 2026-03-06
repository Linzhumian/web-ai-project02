package com.itheima.controller;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //分页查询
    @GetMapping
    public Result page(StudentQueryParam studentQueryParam){
        log.info("分页查询请求参数{}", studentQueryParam);
        PageResult<Student> pageResult = studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }


    //批量删除学员
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("所要删除员工的ID{}", ids);
        studentService.delete(ids);
        return Result.success();
    }

    //添加学员
    @PostMapping
    public Result save(@RequestBody Student student){
        log.info("保存学员信息{}", student);
        studentService.save(student);
        return Result.success();
    }

    //根据ID查询学员
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询ID为{}的学员信息", id);
        Student student = studentService.getInfo(id);
        return Result.success(student);
    }


    //修改学员信息
    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("修改学员信息{}", student);
        studentService.update(student);
        return Result.success();
    }

    //违纪处理
    @PutMapping("/violation/{id}/{score}")
    public Result handleDiscipline(@PathVariable Integer id, @PathVariable Integer score){
        log.info("处理违纪信息{}, {}", id, score);
        studentService.updateStudent(id, score);
        return Result.success();
    }

}
