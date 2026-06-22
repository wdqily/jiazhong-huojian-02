package com.jiazhong.huojian.spring.boot.example.shopping.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Order;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.OrderItem;
import com.jiazhong.huojian.spring.boot.example.shopping.service.OrderItemService;
import com.jiazhong.huojian.spring.boot.example.shopping.service.OrderService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/alipay")
public class AlipayController {

    @Resource
    private AlipayClient alipayClient;

    @Resource
    private OrderService orderService;
    @Resource
    private OrderItemService orderItemService;

    @Value("${alipay.returnUrl}")
    private String returnUrl;

    @GetMapping("/pay")
    public void pay(String orderId, HttpServletResponse response) throws Exception {
        // 1. 从数据库查出刚刚生成的订单
        Order order = orderService.getById(orderId);
        if (order == null) {
            response.getWriter().write("Order not found");
            return;
        }
        QueryWrapper<OrderItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", orderId);
        List<OrderItem> orderItemList = orderItemService.list(queryWrapper);
        if (orderItemList == null || orderItemList.isEmpty()) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('订单数据异常：无商品明细，无法支付！'); window.history.back();</script>");
            return;
        }
        double totalAmount = 0.0;
        for (OrderItem item1 : orderItemList) {
            totalAmount += item1.getPrice() * item1.getNumber();
        }
        // 沙箱环境兜底：如果算出来金额是0或负数（可能是测试数据问题），强制给 0.01 防止支付宝抛异常
        if (totalAmount <= 0) {
            totalAmount = 0.01;
        }

        // 2. 构造支付请求
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setReturnUrl(returnUrl);

        request.setBizContent("{\"out_trade_no\":\"" + order.getId() + "\","
                + "\"total_amount\":\"" + totalAmount + "\","
                + "\"subject\":\"极客商城订单支付\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        // 3. 生成HTML表单并直接输出给浏览器
        String form = alipayClient.pageExecute(request).getBody();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(form);
        response.getWriter().flush();
        response.getWriter().close();
    }
}
