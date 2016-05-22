package com.retrofit.wjh.modelapp2.HttpRequest;

import com.retrofit.wjh.modelapp2.App.AppConfig;
import com.retrofit.wjh.modelapp2.Utils.HttpLoggingInterceptor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wujh on 2016/5/20.
 * Email:1049334820@qq.com
 */
public class RetrofitAipManager {

    public static final String SERVER_URL = "http://apis.baidu.com/apistore/weatherservice/";

    public static final int OVER_TIME_LIMIt = 15;

    public static WeatherInfoService provideClientApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(genericClient())
                .build();
        return retrofit.create(WeatherInfoService.class);
    }


    public static OkHttpClient genericClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
//                                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
//                                .addHeader("Accept-Encoding", "gzip, deflate")
//                                .addHeader("Connection", "keep-alive")
//                                .addHeader("Accept", "*/*")
//                                .addHeader("Cookie", "add cookies here")
                        .addHeader("apikey", "838add4f13aabdcc328d5bb57e5f61e2")
                        .build();
                return chain.proceed(request);
            }

        });
        if (AppConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(interceptor);
        }
        builder.connectTimeout(OVER_TIME_LIMIt, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);
        OkHttpClient httpClient = builder.build();

        return httpClient;
    }

    //        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
//        OkHttpClient httpClient = new OkHttpClient.Builder()
//                .addInterceptor(new Interceptor() {
//                    @Override
//                    public Response intercept(Chain chain) throws IOException {
//                        Request request = chain.request()
//                                .newBuilder()
////                                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
////                                .addHeader("Accept-Encoding", "gzip, deflate")
////                                .addHeader("Connection", "keep-alive")
////                                .addHeader("Accept", "*/*")
////                                .addHeader("Cookie", "add cookies here")
//                                .addHeader("apikey", "838add4f13aabdcc328d5bb57e5f61e2")
//                                .build();
//                        return chain.proceed(request);
//                    }
//
//                })
//                .addInterceptor(interceptor)
//                .retryOnConnectionFailure(true)
//                .connectTimeout(15, TimeUnit.SECONDS)
//                .build();
}
