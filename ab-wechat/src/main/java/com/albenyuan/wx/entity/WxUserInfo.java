package com.albenyuan.wx.entity;

import java.io.Serializable;
import java.util.List;

public class WxUserInfo implements Serializable {
    private String openid;
    private String nickname;
    private Integer sex;
    private String unionid;
    private String city;
    private String country;
    private List<String> privilege;
    private String province;
    private String headimgurl;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getPrivilege() {
        return privilege;
    }

    public void setPrivilege(List<String> privilege) {
        this.privilege = privilege;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WxUserInfo{");
        sb.append("openid='").append(openid).append('\'');
        sb.append(", nickname='").append(nickname).append('\'');
        sb.append(", sex=").append(sex);
        sb.append(", unionid='").append(unionid).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", privilege=").append(privilege);
        sb.append(", province='").append(province).append('\'');
        sb.append(", headimgurl='").append(headimgurl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
