package com.itheima.controller;

import com.itheima.anno.LogOperation;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list(){
//        System.out.println("查询全部部门数据");
        log.info("查询全部部门数据");
        List< Dept > deptList = deptService.findAll();
        return Result.success(deptList);
    }


    /*
    * 方法一: 通过原始的HttpServletRequest对象获取
    * */
//    @DeleteMapping("/depts")
//    public Result delete(HttpServletRequest request){
//        String idStr = request.getParameter("id");
//        int id = Integer.parseInt(idStr);
//        System.out.println("删除部门数据, id: " + id);
//        return Result.success();
//    }


    /*
    * 方法二: 一旦声明了@RequestParam注解，该参数在请求时必须传递，如果不传递将会报错(默认required为true)
    * */
//    @DeleteMapping("/depts")
//    public Result delete(@RequestParam("id") Integer idDel){
//        System.out.println("删除部门数据, id: " + idDel);
//        return Result.success();
//    }

    /*
    * 方法三: 如果请求参数名与形参变量名相同，直接定义方法形参即可接收(省略@RequestParam)
    * */
    @LogOperation
    @DeleteMapping
    public Result delete(Integer id){
//        System.out.println("删除部门数据, id: " + id);
        log.info("删除部门数据, id: {}", id);
        deptService.delete(id);
        return Result.success();
    }


    @LogOperation
    @PostMapping
    public Result add(@RequestBody Dept dept){
//        System.out.println("添加部门数据: " + dept);
        log.info("添加部门数据: {}", dept);
        deptService.add(dept);
        return Result.success();
    }


    //方法一:
/*    @GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable("id") Integer deptId){
        System.out.println("查询部门数据, id: " + deptId);
        Dept dept = deptService.getInfo(deptId);
        return Result(dept);
    }*/

    //方法二:
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
//        System.out.println("查询部门数据, id: " + id);
        log.info("查询部门数据, id: {}", id);
        Dept dept = deptService.getInfo(id);
        return Result.success(dept);
    }

    @LogOperation
    @PutMapping
    public Result update(@RequestBody Dept dept){
//        System.out.println("修改部门数据: " + dept);
        log.info("修改部门数据: {}", dept);
        deptService.update(dept);
        return Result.success();
    }

}
