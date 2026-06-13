package com.jiazhong.huojian.spring.boot.jwt.handler;

import com.jiazhong.huojian.commons.JsonResult;
import com.jiazhong.huojian.commons.ResultTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(exception = UserLoginException.class)
    public JsonResult userLoginException(Exception e) {
        return ResultTool.fail(601, e.getMessage());
    }
}
