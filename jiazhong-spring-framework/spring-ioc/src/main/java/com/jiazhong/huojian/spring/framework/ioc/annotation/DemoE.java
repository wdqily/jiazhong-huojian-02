package com.jiazhong.huojian.spring.framework.ioc.annotation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Data
public class DemoE {
    @Autowired //ref 先byTpye后byName
    @Qualifier("da")//如果有多个byType对象 找名字是da的
    private DemoA a;
    @Resource //ref 先byName后byTpye
    private DemoB b;

}
