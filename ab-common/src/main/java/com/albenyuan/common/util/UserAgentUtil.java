package com.albenyuan.common.util;

/**
 * @Author Alben Yuan
 * @Date 2018-08-14 17:20
 */
public class UserAgentUtil {

    private UserAgentUtil() {
    }

    /**
     * PC 访问
     *
     * @param userAgent
     * @return
     */
    public static boolean isPC(String userAgent) {
        return !isMobile(userAgent);
    }

    /**
     * 移动端访问：iPhone, iPad, iPod, Android, Windows Phone
     *
     * @param userAgent
     * @return
     */
    public static boolean isMobile(String userAgent) {
        return userAgent.indexOf("Mobile") > -1
                || isIPhone(userAgent)
                || isIPad(userAgent)
                || isIPad(userAgent)
                || isAndroid(userAgent)
                || isWP(userAgent);
    }

    public static boolean isAndroid(String userAgent) {
        return userAgent.indexOf("Android") > -1;
    }

    public static boolean isIOS(String userAgent) {
        return isIPhone(userAgent)
                || isIPad(userAgent)
                || isIPod(userAgent);
    }

    public static boolean isIPad(String userAgent) {
        return userAgent.indexOf("ipad") > -1;
    }

    public static boolean isIPhone(String userAgent) {
        return userAgent.indexOf("iphone") > -1;
    }


    public static boolean isIPod(String userAgent) {
        return userAgent.indexOf("ipod") > -1;
    }

    public static boolean isWP(String userAgent) {
        return userAgent.indexOf("windows phone") > -1;
    }

    /**
     * 微信端访问
     *
     * @param userAgent
     * @return
     */
    public static boolean isWeChat(String userAgent) {
        return userAgent.indexOf("MicroMessenger") > -1 || userAgent.indexOf("WebBrowser") > -1;
    }

    /**
     * windows系统访问
     *
     * @param userAgent
     * @return
     */
    public static boolean isWindows(String userAgent) {
        return userAgent.indexOf("") > -1;
    }

    /**
     * MAC 系统访问
     *
     * @param userAgent
     * @return
     */
    public static boolean isMAC(String userAgent) {
        return userAgent.indexOf("Mac OS") > -1;
    }

    public static boolean isMQQBrowser(String userAgent) {
        return userAgent.indexOf("MQQBrowser") > -1;
    }

    public static boolean isNetType(String userAgent) {
        return userAgent.indexOf("NetType") > -1;
    }


}
