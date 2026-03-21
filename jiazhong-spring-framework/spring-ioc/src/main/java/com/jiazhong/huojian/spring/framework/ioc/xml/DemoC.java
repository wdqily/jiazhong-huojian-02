package com.jiazhong.huojian.spring.framework.ioc.xml;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
//集合引用(引用)
public class DemoC {
    private String[] shuzu;
    private List<String> youxujihe;
    private Set<String> wuxujihe;
    private Map<String, String> hashjihe;

}
