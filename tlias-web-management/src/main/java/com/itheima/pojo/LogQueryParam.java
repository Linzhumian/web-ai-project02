package com.itheima.pojo;

import lombok.Data;

@Data
public class LogQueryParam {
    private Integer page = 1;
    private Integer pageSize = 10;
}
