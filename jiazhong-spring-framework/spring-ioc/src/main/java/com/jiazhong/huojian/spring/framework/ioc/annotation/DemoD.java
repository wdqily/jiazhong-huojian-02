package com.jiazhong.huojian.spring.framework.ioc.annotation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class DemoD {
    private Integer id;
    private String name;
    private DemoA da;
    private DemoB bbb;

    public DemoD() {
    }

    @Autowired

    public DemoD(@Value("2") Integer id, @Value("dq") String name, DemoA da, DemoB bbb) {
        this.id = id;
        this.name = name;
        this.da = da;
        this.bbb = bbb;
    }
}
