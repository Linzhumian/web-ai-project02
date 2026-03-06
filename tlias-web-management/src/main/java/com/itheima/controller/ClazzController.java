package com.itheima.controller;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    //班级分页查询
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam){
        log.info("分页查询请求参数{}", clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }

    //删除班级
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("需要删除班级的ID{}", id);
        clazzService.delete(id);
        return Result.success();
    }

    //添加班级
    @PostMapping
    public Result save(@RequestBody Clazz clazz){
        log.info("添加班级信息{}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    //根据ID查询班级信息
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据ID查询班级信息{}", id);
        Clazz clazz = clazzService.getInfo(id);
        return Result.success(clazz);
    }


    //修改班级信息
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("修改班级信息{}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }


    //查询所有班级
    @GetMapping("/list")
    public Result listAll(){
        log.info("查询所有班级");
        List<Clazz> listClazz = clazzService.allfind();
        return Result.success(listClazz);
    }


}
