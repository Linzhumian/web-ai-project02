package com.itheima.service;

import com.itheima.pojo.LogQueryParam;
import com.itheima.pojo.OperateLog;
import com.itheima.pojo.PageResult;

public interface LogService {
    // 分页查询
    PageResult<OperateLog> page(LogQueryParam logQueryParam);
}
