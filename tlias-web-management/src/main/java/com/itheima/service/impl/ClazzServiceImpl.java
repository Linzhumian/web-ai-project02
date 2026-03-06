package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.ClazzMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    //修改班级信息
    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateById(clazz);
    }

    //根据ID查询班级信息
    @Override
    public Clazz getInfo(Integer id) {
        return clazzMapper.getById(id);
    }

    //按照ID删除班级
    @Override
    public void delete(Integer id) {
        clazzMapper.deleteByIds(id);
    }

    //添加班级
    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        //1. 设置分页参数(PageHelper)
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());

        //2. 执行查询
        List<Clazz> clazzList = clazzMapper.list(clazzQueryParam);

        //3. 解析查询结果，并封装
        Page<Clazz> p = (Page<Clazz>) clazzList;
        return new PageResult<Clazz>(p.getTotal(), p.getResult());
    }

    //查询所有班级
    @Override
    public List<Clazz> allfind() {
        return clazzMapper.allFindClass();
    }
}
