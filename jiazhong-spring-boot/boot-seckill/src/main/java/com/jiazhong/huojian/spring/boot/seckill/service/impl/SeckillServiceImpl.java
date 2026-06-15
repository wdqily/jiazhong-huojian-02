package com.jiazhong.huojian.spring.boot.seckill.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.jiazhong.huojian.commons.JsonResult;
import com.jiazhong.huojian.commons.ResultTool;
import com.jiazhong.huojian.spring.boot.seckill.bean.Goods;
import com.jiazhong.huojian.spring.boot.seckill.exception.SeckillMaiguoException;
import com.jiazhong.huojian.spring.boot.seckill.exception.SeckillNotBeginException;
import com.jiazhong.huojian.spring.boot.seckill.exception.SeckillStockIsZeroException;
import com.jiazhong.huojian.spring.boot.seckill.service.SeckillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class SeckillServiceImpl implements SeckillService {

    private StringRedisTemplate stringRedisTemplate;
    private ValueOperations forValue;
    private ListOperations forList;
    private final String stock_key = "SECKILL_STOCK_NUMBER";
    private final String goods_list_key = "SECKILL_GOODS_LIST";
    private final String goods_buy_key = "SECKILL_BUY_LIST";

    public SeckillServiceImpl(StringRedisTemplate stringRedisTemplate) {
        this.forValue = stringRedisTemplate.opsForValue();
        this.forList = stringRedisTemplate.opsForList();
        this.stringRedisTemplate = stringRedisTemplate;
        //清除原来的记录
        this.stringRedisTemplate.delete(goods_buy_key);
        this.stringRedisTemplate.delete(goods_list_key);
        this.forList.rightPush(goods_buy_key, "");
        this.forValue.set(stock_key, "4");
        for (int i = 0; i < 4; i++) {
            Goods goods = new Goods(1, "雪碧", 2.9);
            this.forList.rightPush(goods_list_key, JSONArray.toJSONString(goods));
        }
    }

    @Override
    public JsonResult seckill(String ip) {
        log.info("ip:{}", ip);
        //数据校验
        //1.时间是否到了
        Date seckillDate = new Date(126, Calendar.JUNE, 14, 11, 55, 0);
        if (new Date().before(seckillDate)) {
            throw new SeckillNotBeginException("还没到秒杀时间");
        }
        //2.是否购买过了
        Long indexOf = this.forList.indexOf(goods_buy_key, ip);
        if (indexOf != null) {
            throw new SeckillMaiguoException("你已经购买过了，不能重复购买");
        }
        //3.是否结束
        Object stockNumber = this.forValue.get(stock_key);
        if ("0".equals(stockNumber.toString())) {
            throw new SeckillStockIsZeroException("活动已结束");
        }
        final Object[] goods = new Object[1];
        //开始监控
        stringRedisTemplate.watch(stock_key);
        SessionCallback<List<Object>> sessionCallback = new SessionCallback() {
            @Nullable
            @Override
            public List<Object> execute(RedisOperations operations) throws DataAccessException {
                stringRedisTemplate.multi();
                //库存-1
                forValue.decrement(stock_key);
                //取出商品
                forList.rightPop(goods_list_key);
                //加入购物记录
                forList.rightPush(goods_buy_key, ip);
                return stringRedisTemplate.exec();
            }
        };
        //实际执行
        List<Object> execute = stringRedisTemplate.execute(sessionCallback);
        log.info("execute:{}", execute);
        if (execute.get(1) == null) {
            throw new SeckillStockIsZeroException("秒杀失败");
        }
        return ResultTool.success(goods[0]);
    }
}

