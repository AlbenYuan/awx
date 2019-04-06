package com.albenyuan.wx.sdk;

import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 微信统一下单请求参数，基础类
 * Created by alben on 2017/8/23.
 */
public class PayEntity extends WxEntity {

    protected PayEntity() {
        this.setDeviceInfo("WEB");
    }

    /**
     * 设置订单信息，必填
     *
     * @param outTradeNo 商户单号
     * @param body       商品信息
     * @param detail     商品详情（可选）
     */
    public void setBusinessOrder(String outTradeNo, String body, String detail) {
        this.put("out_trade_no", outTradeNo);
        this.put("body", body);
        if (StringUtils.isNotEmpty(detail)) {
            this.put("detail", detail);
        }
    }

    /**
     * 设置订单信息，必填
     *
     * @param outTradeNo 商户单号
     * @param body       商品信息
     */
    public void setBusinessOrder(String outTradeNo, String body) {
        this.setBusinessOrder(outTradeNo, body, null);
    }


    /**
     * 这是附属信息，可选。支付通知中，会回传此参数
     *
     * @param attach
     */
    public void setAttach(String attach) {
        this.put("attach", attach);
    }

    /**
     * 调用支付客户端 ip（必填）。
     *
     * @param spbillCreateIp ip地址：127.0.0.1
     */
    public void setSpbillCreateIp(String spbillCreateIp) {
        this.put("spbill_create_ip", spbillCreateIp);
    }

    /**
     * 设置超时时间，超时时间不得低于5分钟
     *
     * @param startTime 开始时间
     * @param timeout   有效时长，毫秒
     */
    public void setTimeout(Date startTime, long timeout) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        this.put("time_start", df.format(startTime));
        this.put("time_expire", df.format(new Date(startTime.getTime() + timeout)));
    }

    /**
     * 设置有效时长，超时时间不得低于5分钟，开始时间默认为调用时间
     *
     * @param timeout 有效时长，毫秒
     */
    public void setTimeout(long timeout) {
        this.setTimeout(new Date(), timeout);
    }

    /**
     * 设置默认有效时间，有效时长得5分钟，开始时间为调用时间
     */
    public void setTimeout() {
        this.setTimeout(5 * 60 * 1000);
    }

    /**
     * 设置设备信息（可选），终端设备号(门店号或收银设备ID)，默认请传"WEB"
     *
     * @param deviceInfo
     */
    public void setDeviceInfo(String deviceInfo) {
        this.put("device_info", deviceInfo);
    }

    /**
     * 订单优惠标记(选填)
     *
     * @param goodsTag
     */
    public void setGoodsTag(String goodsTag) {
        this.put("goods_tag", goodsTag);
    }

    /**
     * @param limitPay
     */
    public void setLimitPay(String limitPay) {
        this.put("limit_pay", limitPay);
    }

    /**
     * 设置交易类型
     *
     * @param tradeType
     */
    public void setTradeType(String tradeType) {
        this.put("trade_type", tradeType);
    }

    /**
     * 设置交易场景：小程序(WXA)、公众号(JSAPI)、App(APP)
     *
     * @param tradeScene
     */
    public void setTradeScene(WxPayConstants.TradeScene tradeScene) {
        switch (tradeScene) {
            case APP:
                this.setTradeType("APP");
                break;
            case WXA:
            case JSAPI:
                this.setTradeType("JSAPI");
                break;
        }
        super.setTradeScene(tradeScene);
    }


    public String getOutTradeNo() {
        return entityMap.get("out_trade_no");
    }


    @Override
    public int hashCode() {
        String no = getOutTradeNo();
        return null == no ? 0 : no.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        String no = getOutTradeNo();
        if (null == no) {
            return null == obj;
        }
        return no.equals(obj);
    }

    @Override
    public String toString() {
        return this.entityMap.toString();
    }
}
