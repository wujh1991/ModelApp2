package com.retrofit.wjh.modelapp2.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.retrofit.wjh.modelapp2.HttpRequest.RetrofitAipManager;
import com.retrofit.wjh.modelapp2.HttpRequest.WeatherInfoService;
import com.retrofit.wjh.modelapp2.Model.CityInfo;
import com.retrofit.wjh.modelapp2.PopWindows.BottomPopupOption;
import com.retrofit.wjh.modelapp2.PopWindows.MPopWindow;
import com.retrofit.wjh.modelapp2.R;
import com.retrofit.wjh.modelapp2.Utils.LogUtil;
import com.retrofit.wjh.modelapp2.Utils.NetworkUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "okhttp-MainActivity";
    private Button btnRetrofit;
    private TextView tvRetrofit;
    private Button btnPop;
    private Button btnPop2;

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
        btnPop = (Button) findViewById(R.id.btnPop);
        btnPop2 = (Button) findViewById(R.id.btnPop2);
    }

    private void init() {

    }

    private void setListener() {
        btnRetrofit.setOnClickListener(this);
        btnPop.setOnClickListener(this);
        btnPop2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRetrofit:
                if (NetworkUtil.isNetworkAvailable(MainActivity.this)) {
                    request();
                } else {
                    Toast.makeText(this, "网络连接不可用", Toast.LENGTH_LONG).show();
                    LogUtil.logW(TAG, "网络连接不可用");
                }
                break;
            case R.id.btnPop:
                MPopWindow mPopWindow = new MPopWindow(MainActivity.this);
                mPopWindow.showAtLocation(MainActivity.this.findViewById(R.id.main), Gravity.BOTTOM, 0, 0);
                break;
            case R.id.btnPop2:
                popWindow2();
                break;
        }
    }

    public void popWindow2() {
        BottomPopupOption bottomPopupOption = new BottomPopupOption(MainActivity.this);
        bottomPopupOption.setItemText("拍照", "选择相册");
        bottomPopupOption.setColors();
        bottomPopupOption.setItemClickListener(new BottomPopupOption.onPopupWindowItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position) {
                    case 0:
                        Toast.makeText(MainActivity.this, "拍照", Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "选择相册", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
        // 设置颜色
        bottomPopupOption.showPopupWindow();
    }


    public void request() {
        WeatherInfoService weatherInfoService = RetrofitAipManager.provideClientApi();
        Call<CityInfo> call = weatherInfoService.getString();
        call.enqueue(new Callback<CityInfo>() {
            @Override
            public void onResponse(Call<CityInfo> call, Response<CityInfo> response) {
                LogUtil.logD(TAG, "result--->" + response.body().toString());
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
                Log.v("TAg", throwable.toString());
                tvRetrofit.setText(throwable.toString());
//                tvRetrofit.setText("failure");
            }
        });
    }
}