package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {
    /*
    * 查询所有的部门数据
    * */
    List<Dept> findAll();

    void delete(Integer id);

    void add(Dept dept);

    Dept getInfo(Integer id);

    void update(Dept dept);
}
