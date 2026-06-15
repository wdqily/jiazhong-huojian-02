package com.jiazhong.huojian.spring.boot.seckill.exception;

public class SeckillStockIsZeroException extends RuntimeException {
    public SeckillStockIsZeroException(String message) {
        super(message);
    }
}
