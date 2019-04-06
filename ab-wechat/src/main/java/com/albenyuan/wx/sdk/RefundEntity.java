package com.albenyuan.wx.sdk;

import java.math.BigDecimal;

/**
 * Created by alben on 2017/8/28.
 */
public class RefundEntity extends WxEntity {

    /**
     * 操作员（必填），默认为mch_id
     *
     * @param opUserId
     */
    public void setOpUserId(String opUserId) {
        super.put("op_user_id", opUserId);
    }

    /**
     * 微信订单号（必填），与商户单号二选一即可
     *
     * @param transactionId
     */
    public void setTransactionId(String transactionId) {
        super.put("transaction_id", transactionId);
    }

    /**
     * 商户单号（必填），与微信订单号二选一即可
     *
     * @param outTradeNo
     */
    public void setOutTradeNo(String outTradeNo) {
        super.put("out_trade_no", outTradeNo);
    }

    /**
     * 退款交易号，（必填）
     *
     * @param outRefundNo
     */
    public void setOutRefundNo(String outRefundNo) {
        super.put("out_refund_no", outRefundNo);
    }

    /**
     * 设置退款金额 单位为：分.（必填）
     *
     * @param refundFee
     */
    public void setRefundFee(long refundFee) {
        setRefundFee("" + refundFee);
    }

    /**
     * 设置退款金额，单位为：元.（必填）
     *
     * @param refundFee
     */
    public void setRefundFee(BigDecimal refundFee) {
        setRefundFee("" + convertFee(refundFee));
    }


    /**
     * 退款说明，80字以内
     *
     * @param refundDesc
     */
    public void setRrefundDesc(String refundDesc) {
        super.put("refund_desc", refundDesc);
    }

    /**
     * @param refundAccount
     */
    public void setRefundAccount(String refundAccount) {
        super.put("refund_account", refundAccount);
    }


    /**
     * 设置退款金额，单位为：分
     *
     * @param refundFee 正整数
     */
    private void setRefundFee(String refundFee) {
        super.put("refund_fee", refundFee);
        super.put("refund_fee_type", "CNY");
    }


}
