package com.jiazhong.huojian.spring.boot.example.yaml;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 通过@Value注解获取到单个信息
@Data
@Component
public class First {
    @Value("${a}")
    private Integer var1;
    @Value("${b1}")
    private String var2;
    @Value("${c}")
    private Boolean var3;
    @Value("${array1[1]}")
    private String var4;
    @Value("${array2[2]}")
    private String var5;
    @Value("${obj1.name}")
    private String var6;
    @Value("${obj2.name}")
    private String var7;
    /*//不能直接给数组
    @Value("${array1}")
    private String[] var8;
    //不能直接给对象
    @Value("${obj1}")
    private Object var9;*/

}
