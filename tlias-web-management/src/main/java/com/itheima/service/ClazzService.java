package com.itheima.service;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    //按照ID删除班级
    void delete(Integer id);

    //添加班级
    void save(Clazz clazz);

    //根据ID查询班级信息
    Clazz getInfo(Integer id);

    void update(Clazz clazz);

    List<Clazz> allfind();
}
