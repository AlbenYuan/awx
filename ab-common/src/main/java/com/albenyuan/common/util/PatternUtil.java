package com.albenyuan.common.util;

import org.apache.commons.lang3.StringUtils;


/**
 * @Author Alben Yuan
 * @Date 2018-01-17 23:28
 */

public class PatternUtil {

    private PatternUtil() {
    }

    /**
     *
     */
    private static final String MOBILE = "^(13|15|18|17|16)[0-9]{9}$";

    private static final String CODE_AND_MOBILE = "^\\+[0-9]{2}\\-(13|15|18|17|16)[0-9]{9}$";


    /**
     * 整数
     */
    private static final String INTEGER = "^-?[1-9]\\d*$";

    /**
     * 正整数
     */
    private static final String INTEGER_POSITIVE = "^[1-9]\\d*$";

    /**
     * 负整数
     */
    private static final String INTEGER_NEGATIVE = "^-[1-9]\\d*$";

    /**
     * 数字
     */
    private static final String NUMBER = "^([+-]?)\\d*\\.?\\d+$";

    /**
     * 正数（正整数 + 0）
     */
    private static final String NUMBER_POSITIVE = "^[1-9]\\d*|0$";

    /**
     * 负数（负整数 + 0）
     */
    private static final String NUMBER_NEGATIVE = "^-[1-9]\\d*|0$";

    /**
     * 浮点数
     */
    private static final String DECIMAL = "^([+-]?)\\d*\\.\\d+$";

    /**
     * 正浮点数
     */
    private static final String DECIMAL_POSITIVE = "^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*$";

    /**
     * 负浮点数
     */
    private static final String DECIMAL_NEGATIVE = "^-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*)$";

    /**
     * 浮点数
     */
    private static final String decimal3 = "^-?([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0)$";

    /**
     * 非负浮点数（正浮点数 + 0）
     */
    private static final String DECIMAL_NONEGATIVE = "^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0$";

    /**
     * 非正浮点数（负浮点数 + 0）
     */
    private static final String DECIMAL_NONPOSITIVE = "^(-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*))|0?.0+|0$";

    /**
     * 邮件
     */
    private static final String EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";

    /**
     * 颜色
     */
    private static final String COLOR = "^[a-fA-F0-9]{6}$";

    /**
     * url
     */
    private static final String URL = "^http[s]?=\\/\\/([\\w-]+\\.)+[\\w-]+([\\w-./?%&=]*)?$";


    /**
     * 仅中文
     */
    private static final String CHINESE = "^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$";


    /**
     * 仅ACSII字符
     */
    private static final String ASCII = "^[\\x00-\\xFF]+$";


    /**
     * 邮编
     */
    private static final String ZIP_CODE = "^\\d{6}$";

    /**
     * ip_v4
     */
    private static final String IP4 = "^(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)$";


    /**
     * ip_v6
     */
    private static final String IP6 = "^(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)$";

    /**
     * 非空
     */
    private static final String NOT_EMPTY = "^\\S+$";

    /**
     * 图片
     */
    private static final String PICTURE = "(.*)\\.(jpg|bmp|gif|ico|pcx|jpeg|tif|png|raw|tga)$";

    /**
     * 压缩文件
     */
    private static final String RAR = "(.*)\\.(rar|zip|7zip|tgz)$";

    /**
     * 日期
     */
    private static final String DATE = "^\\d{4}(\\-|\\/|\\.)\\d{1,2}\\1\\d{1,2}$";

    /**
     * QQ号码
     */
    private static final String QQ = "^[1-9]*[1-9][0-9]*$";

    /**
     * 电话号码的函数(包括验证国内区号;国际区号;分机号)
     */
    private static final String TELEPHONE = "^(([0\\+]\\d{2,3}-)?(0\\d{2,3})-)?(\\d{7,8})(-(\\d{1,}))?$";

    /**
     * 用来用户注册。匹配由数字、26个英文字母或者下划线组成的字符串
     */
    private static final String USERNAME = "^\\w+$";

    /**
     * 字母
     */
    private static final String LETTER = "^[A-Za-z]+$";
    private static final String LETTER_AND_SPACE = "^[A-Za-z ]+$";

    /**
     * 大写字母
     */
    private static final String LETTER_UPPER_CASE = "^[A-Z]+$".toLowerCase();

    /**
     * 小写字母
     */
    private static final String LETTER_LOWER_CASE = "^[a-z]+$";

    /**
     * 身份证
     */
    private static final String ID_CARD = "^[1-9]([0-9]{14}|[0-9]{17})$";

    /**
     * 判断字符串是否为浮点数
     */
    private static final String isFloat = "^[-]?\\d+(\\.\\d+)?$";

    /**
     * 判断字符串是否为正浮点数
     */
    private static final String isUFloat = "^\\d+(\\.\\d+)?$";

    /**
     * 判断是否是整数
     */
    private static final String isInteger = "^[-]?\\d+$";

    /**
     * 判断是否是正整数
     */
    private static final String IS_POSITIVE_INTEGER = "^\\d+$";

    /**
     * 判断车辆Vin码
     */
    private static final String IS_CAR_VIN = "^[1234567890WERTYUPASDFGHJKLZXCVBNM]{13}[0-9]{4}$";


    /**
     * 手机号
     */
    public static boolean isMobile(String input) {
        return matches(MOBILE, input);
    }

    public static boolean isCodeAndMobile(String input) {
        return matches(CODE_AND_MOBILE, input);
    }


    /**
     * 整数
     */
    public static boolean isIntege(String input) {
        return matches(INTEGER, input);
    }


    /**
     * 正整数
     */
    public static boolean isintege1(String input) {
        return matches(INTEGER_POSITIVE, input);
    }


    /**
     * 负整数
     */
    public static boolean isIntege2(String input) {
        return matches(INTEGER_NEGATIVE, input);
    }


    /**
     * 数字
     */
    public static boolean isNum(String input) {
        return matches(NUMBER, input);
    }


    /**
     * 正数（正整数 + 0）
     */
    public static boolean isNum1(String input) {
        return matches(NUMBER_POSITIVE, input);
    }


    /**
     * 负数（负整数 + 0）
     */
    public static boolean isNum2(String input) {
        return matches(NUMBER_NEGATIVE, input);
    }


    /**
     * 浮点数
     */
    public static boolean isDecimal(String input) {
        return matches(DECIMAL, input);
    }


    /**
     * 正浮点数
     */
    public static boolean isDecimal1(String input) {
        return matches(DECIMAL_POSITIVE, input);
    }


    /**
     * 负浮点数
     */
    public static boolean isDecimal2(String input) {
        return matches(DECIMAL_NEGATIVE, input);
    }


    /**
     * 浮点数
     */
    public static boolean isDecimal3(String input) {
        return matches(decimal3, input);
    }


    /**
     * 非负浮点数（正浮点数 + 0）
     */
    public static boolean isDecimal4(String input) {
        return matches(DECIMAL_NONEGATIVE, input);
    }


    /**
     * 非正浮点数（负浮点数 + 0）
     */
    public static boolean isDecimal5(String input) {
        return matches(DECIMAL_NONPOSITIVE, input);
    }


    /**
     * 邮件
     */
    public static boolean isEmail(String input) {
        return matches(EMAIL, input);
    }


    /**
     * 颜色
     */
    public static boolean isColor(String input) {
        return matches(COLOR, input);
    }


    /**
     * url
     */
    public static boolean isUrl(String input) {
        return matches(URL, input);
    }


    /**
     * 中文
     */
    public static boolean isChinese(String input) {
        return matches(CHINESE, input);
    }


    /**
     * ascii码
     */
    public static boolean isAscii(String input) {
        return matches(ASCII, input);
    }


    /**
     * 邮编
     */
    public static boolean isZipcode(String input) {
        return matches(ZIP_CODE, input);
    }


    /**
     * IP地址
     */
    public static boolean isIP6(String input) {
        return matches(IP6, input);
    }


    /**
     * IP地址
     */
    public static boolean isIP4(String input) {
        return matches(IP4, input);
    }


    /**
     * 非空
     */
    public static boolean isNotEmpty(String input) {
        return matches(NOT_EMPTY, input);
    }


    /**
     * 图片
     */
    public static boolean isPicture(String input) {
        return matches(PICTURE, input);
    }


    /**
     * 压缩文件
     */
    public static boolean isRar(String input) {
        return matches(RAR, input);
    }


    /**
     * 日期
     */
    public static boolean isDate(String input) {
        return matches(DATE, input);
    }


    /**
     * qq
     */
    public static boolean isQQ(String input) {
        return matches(QQ, input);
    }


    /**
     * 电话号码的函数(包括验证国内区号;国际区号;分机号)
     */
    public static boolean isTel(String input) {
        return matches(TELEPHONE, input);
    }


    /**
     * 用来用户注册。匹配由数字、26个英文字母或者下划线组成的字符串
     */
    public static boolean isUserName(String input) {
        return matches(USERNAME, input);
    }


    /**
     * 字母
     */
    public static boolean isLetter(String input) {
        return matches(LETTER, input);
    }

    public static boolean isLetterAndSpace(String input) {
        return matches(LETTER_AND_SPACE, input);
    }


    /**
     * 小写字母
     */
    public static boolean isLowLetter(String input) {
        return matches(LETTER_LOWER_CASE, input);
    }


    /**
     * 大写字母
     */
    public static boolean isUpperLetter(String input) {
        return matches(LETTER_UPPER_CASE, input);
    }


    /**
     * 身份证
     */
    public static boolean isIDCard(String input) {
        return matches(ID_CARD, input);
    }

    public static boolean isFloat(String input) {
        return matches(isFloat, input);
    }

    public static boolean isUFloat(String input) {
        return matches(isUFloat, input);
    }

    public static boolean isInteger(String input) {
        return matches(isInteger, input);
    }

    public static boolean isUInteger(String input) {
        return matches(IS_POSITIVE_INTEGER, input);
    }

    public static boolean isCarVin(String carVin) {
        return matches(IS_CAR_VIN, carVin);
    }


    /**
     * 手机号中间四位替换成星号
     *
     * @param mobile
     * @return
     */
    public static String maskMobile(String mobile) {
        return maskMobile(mobile, "****");
    }


    /**
     * 手机号中间四位自定义替换
     *
     * @param mobile
     * @param transCode 中间四位目标值 如GXJF 将136GXJF1111
     * @return
     */
    public static String maskMobile(String mobile, String transCode) {
        if (StringUtils.isNotEmpty(mobile) && isMobile(mobile)) {
            transCode = StringUtils.isEmpty(transCode) ? "****" : transCode;
            mobile = mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", String.format("$1%s$2", transCode));
        }
        return mobile;
    }


    /**
     * 邮箱地址加星号
     *
     * @param email
     * @return
     */
    public static String maskEmail(String email) {
        if (StringUtils.isNotEmpty(email) && isEmail(email)) {
            String userName = email.substring(0, email.indexOf("@"));
            int len = userName.length();
            if (len >= 5) {
                int total = len - 3;
                int half = total / 2;
                int start = half;
                int end = len - half;
                if (total % 2 != 0) {
                    end = end - 1;
                }
                StringBuilder sb = new StringBuilder(email);
                for (int i = start; i < end; i++) {
                    sb.setCharAt(i, '*');
                }
                return sb.toString();
            }
        }
        return email;
    }


    /**
     * 账号中间四位自定义替换
     *
     * @param account
     * @return
     */
    public static String maskTradeAccount(String account) {
        return account.replaceAll("(\\d{7})\\d*(\\d{4})", "$1****$2");
    }


    public static boolean matches(String regex, String input) {
        return StringUtils.isEmpty(input) ? false : input.matches(regex);
    }

}
