package com.retrofit.wjh.modelapp2.Model;

/**
 * Created by wujh on 2016/5/20.
 * Email:1049334820@qq.com
 */
public class City {
    private String cityName;
    private String provinceName;
    private String cityCode;//天气预报城市代码
    private String zipCode;//邮编
    private String telAreaCode;//电话区号

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTelAreaCode() {
        return telAreaCode;
    }

    public void setTelAreaCode(String telAreaCode) {
        this.telAreaCode = telAreaCode;
    }
}
