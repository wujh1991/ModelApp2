package com.retrofit.wjh.modelapp2.Model;


import com.google.gson.Gson;

/**
 * Created by wujh on 2016/5/20.
 * Email:1049334820@qq.com
 */
public class CityInfo {
    private int errNum;
    private String retMsg;
    private City retData;

    public int getErrNum() {
        return errNum;
    }

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public City getRetData() {
        return retData;
    }

    public void setRetData(City retData) {
        this.retData = retData;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this).toString();
    }
}
