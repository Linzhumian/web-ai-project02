package com.itheima.exception;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handleException(Exception e){
        log.error("程序出错啦~", e);
        return Result.error("出错啦，请联系管理员~");
    }

    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e){
        log.error("程序出错啦~", e);
        String message = e.getMessage();  //.getMessage()异常对象的方法，用来获取异常的具体描述信息。
        int i = message.indexOf("Duplicate entry");  //.indexOf()用于查找位置的方法，可以在字符串或数组中找某个字符/子串第一次出现的位置。
        String errMsg = message.substring(i);  //.substring()用于截取字符串的方法，可以取字符串中的一部分。
        String[] arr = errMsg.split(" ");  //.split()用于分割字符串的方法，根据指定的分隔符把字符串拆分成字符串数组。
        return Result.error(arr[2] + " 已存在~");
    }

}
