package com.jiazhong.huojian.spring.boot.alipay.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.jiazhong.huojian.commons.JsonResult;
import com.jiazhong.huojian.commons.ResultTool;
import com.jiazhong.huojian.spring.boot.alipay.bean.Alipay;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alipay")
public class AlipayController {
    @Value("${appId}")
    private String appId;
    @Value("${privateKey}")
    private String privateKey;
    @Value("${publicKey}")
    private String publicKey;
    @Value("${notifyUrl}")
    private String notifyUrl;
    @Value("${returnUrl}")
    private String returnUrl;
    @Value("${signType}")
    private String signType;
    @Value("${charset}")
    private String charset;
    @Value("${gatewayUrl}")
    private String gatewayUrl;

    private AlipayClient alipayClient;

    private Alipay alipay;

    @SneakyThrows
    @RequestMapping("/pay")
    public String pay(Alipay alipay) {
        this.alipay = alipay;
        alipayClient = new DefaultAlipayClient(gatewayUrl, appId, privateKey, "json",
                charset, publicKey, signType);
        AlipayTradePagePayRequest alipayTradePagePayRequest = new AlipayTradePagePayRequest();
        alipayTradePagePayRequest.setReturnUrl(returnUrl);
        alipayTradePagePayRequest.setNotifyUrl(notifyUrl);
        String json = JSONArray.toJSONString(alipay);
        alipayTradePagePayRequest.setBizContent(json);
        return alipayClient.pageExecute(alipayTradePagePayRequest).getBody();
    }

    @SneakyThrows
    @GetMapping("/query")
    public JsonResult query() {
        AlipayTradeQueryRequest alipayTradeQueryRequest = new AlipayTradeQueryRequest();
        alipayTradeQueryRequest.setBizContent(JSONArray.toJSONString(alipay));
        AlipayTradeQueryResponse queryResponse = alipayClient.execute(alipayTradeQueryRequest);
        return ResultTool.success(queryResponse.getTradeStatus());
    }

    @SneakyThrows
    @GetMapping("/refund")
    public JsonResult refund() {
        AlipayTradeRefundRequest alipayTradeRefundRequest = new AlipayTradeRefundRequest();
        alipay.setRefund_amount(alipay.getTotal_amount());
        alipayTradeRefundRequest.setBizContent(JSONArray.toJSONString(alipay));
        AlipayTradeRefundResponse refundResponse = alipayClient.execute(alipayTradeRefundRequest);
        if (refundResponse.isSuccess()) {
            return ResultTool.success("退款成功");
        }
        return ResultTool.fail(500, "退款失败");
    }

    @GetMapping("/success")
    public JsonResult success() {
        return ResultTool.success("支付成功");
    }

}
