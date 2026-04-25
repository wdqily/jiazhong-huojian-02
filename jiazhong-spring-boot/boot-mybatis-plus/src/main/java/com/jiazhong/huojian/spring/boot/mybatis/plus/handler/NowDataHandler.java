package com.jiazhong.huojian.spring.boot.mybatis.plus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class NowDataHandler implements MetaObjectHandler {
    //添加时的自动填充
    public void insertFill(MetaObject metaObject) {
        log.info("用户开始执行添加操作，我负责将默认值赋值指定字段");
        this.strictInsertFill(metaObject, "hireDate", this::getNowData, String.class);

    }

    //更细时的自动填充
    public void updateFill(MetaObject metaObject) {
        log.info("用户开始执行更新操作，我负责将默认值赋值指定字段");
        this.strictUpdateFill(metaObject, "hireDate", this::getNowData, String.class);
    }

    public String getNowData() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());

    }
}
