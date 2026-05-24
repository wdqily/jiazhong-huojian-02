package com.jiazhong.huojian.spring.boot.example.shopping.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pay")
@CrossOrigin
public class PayController {

    // 从 yaml 中读取配置
    @Value("${alipay.app-id}")
    private String appId;
    @Value("${alipay.merchant-private-key}")
    private String privateKey;
    @Value("${alipay.alipay-public-key}")
    private String alipayPublicKey;
    @Value("${alipay.gateway-url}")
    private String gatewayUrl;
    @Value("${alipay.return-url}")
    private String returnUrl;
    @Value("${alipay.notify-url}")
    private String notifyUrl;

    /**
     * 发起支付请求
     *
     * @param traceNo     订单号（你自己数据库生成的唯一编号）
     * @param totalAmount 订单总金额
     * @param subject     订单标题（比如：极客商城-购物结算）
     * @return 返回的是一段 HTML 代码，前端直接接收并 document.write 写进页面即可跳转
     */
    @GetMapping(value = "/ali", produces = "text/html;charset=utf-8")
    public String pay(@RequestParam("traceNo") String traceNo,
                      @RequestParam("totalAmount") Double totalAmount,
                      @RequestParam("subject") String subject) throws AlipayApiException {

        // 1. 初始化支付宝客户端 (这里的格式是固定的)
        AlipayClient alipayClient = new DefaultAlipayClient(
                gatewayUrl, appId, privateKey, "json", "UTF-8", alipayPublicKey, "RSA2");

        // 2. 创建支付请求对象
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setNotifyUrl(notifyUrl);
        request.setReturnUrl(returnUrl);

        // 3. 组装订单参数 (JSON格式)
        request.setBizContent("{\"out_trade_no\":\"" + traceNo + "\","
                + "\"total_amount\":\"" + totalAmount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        // 4. 调用 SDK 发起请求，生成 HTML 表单
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        // 5. 返回给前端
        return form;
    }
}