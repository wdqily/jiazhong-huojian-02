package com.jiazhong.huojian.spring.boot.alipay.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Alipay implements Serializable {
    // 描述⼀个订单号
    private String out_trade_no;
    // 订单名称
    private String subject;
    // 订单付款⾦额
    private String total_amount;
    // 订单的描述
    private String body;
    // 退款金额
    private String refund_amount;

    // PC⽹⻚⽀付必传参数
    private String product_code = "FAST_INSTANT_TRADE_PAY";
}
