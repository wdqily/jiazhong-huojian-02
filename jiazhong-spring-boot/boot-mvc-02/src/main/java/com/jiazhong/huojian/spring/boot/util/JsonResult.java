package com.jiazhong.huojian.spring.boot.util;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class JsonResult<T> implements Serializable {
    private Boolean success;//是否成功
    private Integer code;//返回的状态码
    private T data;//返回的具体数据
    private String error;//返回的错误信息

    public JsonResult(T data) {
        this.success = true;
        this.code = 200;
        this.data = data;
    }

    public JsonResult(Integer code, String error) {
        this.success = false;
        this.code = code;
        this.error = error;
    }
}
