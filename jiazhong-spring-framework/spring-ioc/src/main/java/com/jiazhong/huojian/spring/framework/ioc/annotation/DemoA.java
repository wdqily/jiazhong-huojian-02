package com.jiazhong.huojian.spring.framework.ioc.annotation;

import lombok.Data;
import org.springframework.stereotype.Component;

//产生当前类的对象
/*
<bean></bean>
*/
//如果未指定对象，默认名称是类名首字母小写，demoA
@Component("da")//在其他包类上
/*
@Repository:一般在dao包类上
@Service:一般在service包类上
@Controller:一般在controller包类上
*/
@Data
public class DemoA {

}
