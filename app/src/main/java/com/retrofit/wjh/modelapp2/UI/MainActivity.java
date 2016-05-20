package com.retrofit.wjh.modelapp2.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.retrofit.wjh.modelapp2.HttpRequest.RetrofitAipManager;
import com.retrofit.wjh.modelapp2.HttpRequest.WeatherInfoService;
import com.retrofit.wjh.modelapp2.Model.CityInfo;
import com.retrofit.wjh.modelapp2.R;
import com.retrofit.wjh.modelapp2.Utils.LogUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "okhttp-MainActivity";
    private Button btnRetrofit;
    private TextView tvRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        init();
        setListener();
    }

    private void findViews() {
        btnRetrofit = (Button) findViewById(R.id.btnRetrofit);
        tvRetrofit = (TextView) findViewById(R.id.tvRetrofit);
    }

    private void init() {

    }

    private void setListener() {
        btnRetrofit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRetrofit:
                request();
                break;
        }
    }

    public void request() {
        WeatherInfoService weatherInfoService = RetrofitAipManager.provideClientApi();
        Call<CityInfo> call = weatherInfoService.getString();
        call.enqueue(new Callback<CityInfo>() {
            @Override
            public void onResponse(Call<CityInfo> call, Response<CityInfo> response) {
                LogUtil.logD(TAG,"result--->" + response.body().toString());
                tvRetrofit.setText(response.body().getErrNum() + "\n"
                        + response.body().getRetMsg() + "\n"
                        + response.body().getRetData().getCityCode() + "\n"
                        + response.body().getRetData().getCityName() + "\n"
                        + response.body().getRetData().getProvinceName() + "\n"
                        + response.body().getRetData().getTelAreaCode() + "\n"
                        + response.body().getRetData().getZipCode() + "\n"
                );
            }

            @Override
            public void onFailure(Call<CityInfo> call, Throwable throwable) {
                Log.v("TAg",throwable.toString());
                tvRetrofit.setText(throwable.toString());
//                tvRetrofit.setText("failure");
            }
        });
    }
}