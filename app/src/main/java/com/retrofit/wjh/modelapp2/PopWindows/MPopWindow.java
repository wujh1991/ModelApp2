package com.retrofit.wjh.modelapp2.PopWindows;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.retrofit.wjh.modelapp2.R;

/**
 * Created by wujh on 2016/5/21.
 * Email:1049334820@qq.com
 */
public class MPopWindow extends PopupWindow implements View.OnClickListener{

    private View view;
    private Button btnClose;

    public MPopWindow(Context context) {
        view = LayoutInflater.from(context).inflate(R.layout.layout_pop_window, null, false);

        btnClose = (Button) view.findViewById(R.id.btnClose);
        btnClose.setOnClickListener(this);
        this.setContentView(view);
        this.setOutsideTouchable(true);
        this.setFocusable(true);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setAnimationStyle(R.style.AnimBottom);
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        this.setBackgroundDrawable(dw);

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int height = view.findViewById(R.id.llPop).getTop();
                int y = (int) event.getY();
                if (y < height) {
                    dismiss();
                }
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnClose:
                this.dismiss();
                break;
        }
    }
}
