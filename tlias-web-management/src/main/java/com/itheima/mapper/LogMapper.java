package com.itheima.mapper;

import com.itheima.pojo.LogQueryParam;
import com.itheima.pojo.OperateLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {
    //分页查询
    @Select("select o.*, e.name OperateEmpName from operate_log o join emp e on o.operate_emp_id = e.id")
    List<OperateLog> list(LogQueryParam logQueryParam);
}
