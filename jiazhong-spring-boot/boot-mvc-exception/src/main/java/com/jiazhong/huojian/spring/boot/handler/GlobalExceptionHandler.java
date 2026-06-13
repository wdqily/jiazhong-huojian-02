package com.jiazhong.huojian.spring.boot.handler;

import com.jiazhong.huojian.commons.JsonResult;
import com.jiazhong.huojian.commons.ResultTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
//@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(exception = ArithmeticException.class)
    public JsonResult arithmeticException(Exception e) {
        log.info("出现了数学异常情况");
        return ResultTool.fail(601, e.getMessage());
    }

    @ExceptionHandler(exception = IndexOutOfBoundsException.class)
    public JsonResult indexOutOfBoundsException(Exception e) {
        log.info("出现了越界异常情况");
        return ResultTool.fail(602, e.getMessage());
    }
}
