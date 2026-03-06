package com.itheima.service;

import com.itheima.pojo.JobOption;
import com.itheima.pojo.StudentCount;

import java.util.List;
import java.util.Map;

public interface ReportService {

    //统计员工职位人数
    JobOption getEmpJobData();

    //统计员工性别人数
    List<Map<String, Object>> getEmpGenderData();

    //学员学历统计
    List<Map<String, Object>> getStudentDegreeData();

    //班级人数统计
    StudentCount getStudentCountData();
}
