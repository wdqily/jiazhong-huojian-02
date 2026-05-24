package com.jiazhong.huojian.spring.boot.util;

public class ResultTool {
    public static JsonResult success(Object data) {
        return new JsonResult(data);
    }

    public static JsonResult fail(int code, String error) {
        return new JsonResult(code, error);
    }
}
