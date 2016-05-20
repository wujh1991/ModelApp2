package com.retrofit.wjh.modelapp2.HttpRequest;

import com.retrofit.wjh.modelapp2.Model.CityInfo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by wujh on 2016/5/20.
 * Email:1049334820@qq.com
 */
public interface WeatherInfoService {
    @GET("cityinfo?cityname=厦门")
    Call<CityInfo> getString();
}


