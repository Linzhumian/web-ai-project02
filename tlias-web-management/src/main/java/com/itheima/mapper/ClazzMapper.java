package com.itheima.mapper;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClazzMapper {

    List<Clazz> list(ClazzQueryParam classQueryParam);

    //删除班级
    @Delete("delete from clazz where id = #{id} ")
    void deleteByIds(Integer id);

    @Insert("insert into clazz(name, room, begin_date, end_date, master_id, subject, create_time, update_time) values(#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId}, #{subject}, #{createTime}, #{updateTime})")
    void insert(Clazz clazz);

    Clazz getById(Integer id);

    //根据ID修改班级信息
    void updateById(Clazz clazz);

    @Select("select c.*, e.name masterName, (case" +
            "        when now() > c.end_date then '已结课'" +
            "        when now() < c.begin_date then '未开班'" +
            "        else '在读中' end" +
            "        ) status from clazz c left join emp e on c.master_id = e.id")
    List<Clazz> allFindClass();
}
