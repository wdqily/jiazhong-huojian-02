package com.jiazhong.huojian.spring.boot.seckill.exception;

import com.jiazhong.huojian.commons.JsonResult;
import com.jiazhong.huojian.commons.ResultTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = SeckillNotBeginException.class)
    public JsonResult seckillNotBegin(Exception e) {
        return ResultTool.fail(501, e.getMessage());
    }

    @ExceptionHandler(value = SeckillMaiguoException.class)
    public JsonResult seckillMaiguo(Exception e) {
        return ResultTool.fail(502, e.getMessage());
    }

    @ExceptionHandler(value = SeckillStockIsZeroException.class)
    public JsonResult seckillStockIsZero(Exception e) {
        return ResultTool.fail(503, e.getMessage());
    }
}
