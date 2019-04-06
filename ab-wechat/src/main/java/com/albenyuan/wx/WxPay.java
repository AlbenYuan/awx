package com.albenyuan.wx;

import com.albenyuan.wx.constant.TradeScene;
import com.albenyuan.wx.sdk.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by alben on 2017/8/24.
 */
public class WxPay {

    private static final Logger logger = LoggerFactory.getLogger(WxPay.class);

    /**
     * 统一下单
     *
     * @return
     */
    public static Map<String, String> buildOrder(PayEntity payEntity) throws Exception {
        Map<String, String> map = payEntity.getEntityMap();
        WxPayConfig config = FlygoWxConfig.getInstance(payEntity.getTradeScene());
        logger.info("payEntity:", payEntity);
        com.albenyuan.wx.sdk.WxPay pay = new com.albenyuan.wx.sdk.WxPay(config);
        pay.setSignType();
        Map<String, String> wxOrder = pay.unifiedOrder(map);
        logger.info("wx pay unifiedOrder:" + wxOrder);
        String prepayId = wxOrder.get("prepay_id");
        if (StringUtils.isEmpty(prepayId)) {
            throw new Exception(wxOrder.get("return_msg"));
        }
        return pay.buildOrder(prepayId);
    }

    /**
     * 校验微信支付回调签名
     *
     * @param data 回调的参数
     * @return
     * @throws Exception
     */
    public static boolean verfiyCallbackSignature(Map<String, String> data) throws Exception {
        WxPayConfig config = FlygoWxConfig.getInstance(TradeScene.WXA);
        com.albenyuan.wx.sdk.WxPay pay = new com.albenyuan.wx.sdk.WxPay(config);
        return pay.isPayResultNotifySignatureValid(data);
    }

    /**
     * 退款单申请
     *
     * @param refundEntity
     * @return
     * @throws Exception
     */
    public static Map<String, String> refund(RefundEntity refundEntity) throws Exception {
        Map<String, String> map = refundEntity.getEntityMap();
        WxPayConfig config = FlygoWxConfig.getInstance(refundEntity.getTradeScene());
        com.albenyuan.wx.sdk.WxPay pay = new com.albenyuan.wx.sdk.WxPay(config);
        pay.setSignType();
        return pay.refund(map);
    }

}
