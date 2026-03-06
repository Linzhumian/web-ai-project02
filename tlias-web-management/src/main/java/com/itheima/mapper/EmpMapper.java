package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.LoginInfo;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface EmpMapper {

    //第一种分页查询的方法
    /*@Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
    public Long count();

    @Select("select e.*, d.name deptName from emp e " +
            "join dept d on e.dept_id = d.id order by e.update_time desc limit #{start}, #{pageSize}")
    public List<Emp> list(Integer start, Integer pageSize);*/

    //第二种根据PageHelper分页查询
    //@Select("select e.*, d.name deptName from emp e join dept d on e.dept_id = d.id order by e.update_time desc")
    //public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);
    public List<Emp> list(EmpQueryParam empQueryParam);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "VALUES(#{username}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    void deleteByIds(List<Integer> ids);

    //根据ID查询员工信息以及员工工作经历
    Emp getById(Integer id);


    //根据ID更新员工的基本新信息
    void updateById(Emp emp);


    //统计员工职位人数
    List<Map<String, Object>> countEmpJobData();

    //统计员工性别人数
    List<Map<String, Object>> countEmpGenderData();


    @Select("select * from emp")
    List<Emp> findEmp();

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp selectByUsernameAndPassword(Emp emp);
}
