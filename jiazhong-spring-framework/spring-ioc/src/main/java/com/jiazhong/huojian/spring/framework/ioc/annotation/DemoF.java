package com.jiazhong.huojian.spring.framework.ioc.annotation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Data
public class DemoF {
    @Value("20")
    private Integer id;
    @Resource
    private DemoA da;
    @Autowired
    private DemoB db;

    //@Autowired 可以省略
    public DemoF(@Value("66") Integer id, DemoA da, DemoB db) {
        this.id = id;
        this.da = da;
        this.db = db;
    }

    //    @Autowired 可以省略
    public void c(@Autowired DemoC demoC) {
        System.out.println(demoC);

    }
}
