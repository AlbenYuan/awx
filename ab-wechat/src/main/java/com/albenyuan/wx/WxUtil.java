package com.albenyuan.wx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.albenyuan.wx.entity.AccessToken;
import com.albenyuan.wx.entity.WxAccessToken;
import com.albenyuan.wx.entity.WxSessionKey;
import com.albenyuan.wx.exception.WxException;

/**
 * @Author Alben Yuan
 * @Date 2017-12-06 10:56
 */
public class WxUtil {

    /**
     * @param json
     * @throws WxException
     */
    public static void validateResult(String json) throws WxException {
        validateResult(JSON.parseObject(json));
    }

    public static void validateResult(JSONObject jsonObject) throws WxException {
        if (jsonObject.containsKey("errcode")) {
            Integer code = jsonObject.getInteger("errcode");
            throw new WxException(code, jsonObject.toJSONString());
        }
    }

    public static AccessToken parseAccessToken(String text) {
        JSONObject jsonObject = JSON.parseObject(text);
        WxUtil.validateResult(jsonObject);
        AccessToken accessToken = new AccessToken();
        accessToken.setAccessToken(jsonObject.getString("access_token"));
        accessToken.setExpiresIn(jsonObject.getInteger("expires_in"));
        return accessToken;
    }

    public static WxAccessToken parseWxAccessToken(String text) {
        JSONObject jsonObject = JSON.parseObject(text);
        validateResult(jsonObject);
        WxAccessToken accessToken = new WxAccessToken();
        accessToken.setAccessToken(jsonObject.getString("access_token"));
        accessToken.setExpiresIn(jsonObject.getInteger("expires_in"));
        accessToken.setOpenId(jsonObject.getString("openid"));
        accessToken.setRefreshToken(jsonObject.getString("refresh_token"));
        return accessToken;
    }


    public static WxSessionKey parseToSessionKey(String text) {
        JSONObject jsonObject = JSON.parseObject(text);
        validateResult(jsonObject);
        WxSessionKey sessionKey = new WxSessionKey();
        sessionKey.setOpenId(jsonObject.getString("openid"));
        sessionKey.setSessionKey(jsonObject.getString("session_key"));
        sessionKey.setUnionId(jsonObject.getString("unionid"));
        return sessionKey;
    }
}
