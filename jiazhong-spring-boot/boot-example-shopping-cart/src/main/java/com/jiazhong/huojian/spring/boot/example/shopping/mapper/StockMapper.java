package com.jiazhong.huojian.spring.boot.example.shopping.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StockMapper extends BaseMapper<Stock> {
    @Update("update stock set number=number-#{number} where goods_id=#{bookId}")
    void updateNumberAndBookId(@Param("bookId") String bookId, @Param("number") int number);
}
