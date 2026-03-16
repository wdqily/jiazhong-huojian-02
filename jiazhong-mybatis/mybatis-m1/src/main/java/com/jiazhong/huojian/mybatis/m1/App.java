package com.jiazhong.huojian.mybatis.m1;

import com.jiazhong.huojian.mybatis.m1.been.Custom;
import com.jiazhong.huojian.mybatis.m1.mapper.CustomMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // 加载配置文件
        InputStream inputStream = App.class.getClassLoader().getResourceAsStream("config.xml");
        // 创建会话工厂
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建会话
        SqlSession session = ssf.openSession();
        // 获取到对象
        CustomMapper customMapper = session.getMapper(CustomMapper.class);
        // 调用方法
        List<Custom> list = customMapper.findAll();
        list.forEach(System.out::println);

        Custom custom = new Custom();
        custom.setId(53);
        custom.setName("wang");
        custom.setCity("上海");
        custom.setCountry("中国");
        //添加
//       customMapper.saveCustom(custom);
        //更新
//        customMapper.updateCustom(custom);
        //删除
//        customMapper.deleteCustom(53);
        //二次操作确认
        session.commit();
        // 关闭会话
        session.close();
    }
}
