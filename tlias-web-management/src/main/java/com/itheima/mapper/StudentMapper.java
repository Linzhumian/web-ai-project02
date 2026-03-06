package com.itheima.mapper;

import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    //分页查询
    List<Student> list(StudentQueryParam studentQueryParam);

    //删除学员
    void deleteByIds(List<Integer> ids);

    //添加学员
    @Insert("insert into student(name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, create_time, update_time)" +
            "values (#{name}, #{no}, #{gender}, #{phone}, #{idCard}, #{isCollege}, #{address},#{degree}, #{graduationDate}, #{clazzId}, #{createTime}, #{updateTime})")
    void insert(Student student);

    //根据ID查询学员信息
    Student getById(Integer id);

    //根据ID修改学员信息
    void updateById(Student student);

    //违纪处理
    @Update("update student set violation_score = violation_score + #{score}, violation_count = violation_count + 1, update_time = now() where id = #{id}")
    void updateStudent(Integer id, Integer score);

    //学员学历统计
    List<Map<String, Object>> countStudentData();

    //班级人数统计
    List<Map<String, Object>> countStudentClazzData();
}
