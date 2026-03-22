package com.jiazhong.huojian.spring.framework.ioc.annotation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class DemoC {
    //如何给属性赋值
    @Value("1")//value
    private Integer id;
    @Value("lisi")
    private String name;
    @Autowired//ref
    private DemoA da;
    @Autowired
    private DemoB bbb;
}
