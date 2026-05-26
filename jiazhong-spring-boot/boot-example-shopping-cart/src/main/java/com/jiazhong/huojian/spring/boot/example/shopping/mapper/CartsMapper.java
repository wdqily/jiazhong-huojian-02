package com.jiazhong.huojian.spring.boot.example.shopping.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Carts;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartsMapper extends BaseMapper<Carts> {
    @Delete("delete from carts")
    void removeAll();

}
