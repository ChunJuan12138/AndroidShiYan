package com.example.ZZW.mobileshop.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ZZW.mobileshop.R;
import com.example.ZZW.mobileshop.common.BaseActivity;
import com.example.ZZW.mobileshop.common.MobileShopApp;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;



public class AdActivity extends BaseActivity {


    private TextView tv_skip;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ad;
    }

    @Override
    protected void initView() {
        super.initView();
        //显示图片
        tv_skip = (TextView) findViewById(R.id.tv_skip);
        tv_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skip();
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.iv_image);
        //String url = "http://10.37.59.210/MobileShop/img/ad/new_ad_img.jpg";
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1575220266464&di=9ca7fc981448479014bade5080fa940c&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20170407%2F50c0aa3580254feb84f15cca42c0450f_th.jpeg";

        ImageLoader.getInstance().displayImage(url, imageView, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                MobileShopApp.handler.post(jumpTread);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                MobileShopApp.handler.post(jumpTread);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                MobileShopApp.handler.post(jumpTread);
            }
        });

    }

    private void skip() {
        Intent intent = new Intent(AdActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        c_count = COUNT;
        MobileShopApp.handler.removeCallbacks(jumpTread);
    }

    private static final String SKIP_TEXT = "点击跳过 %d";
    private final static int COUNT = 5;
    private final static int DELAYED = 1000;
    private int c_count = COUNT;

    private Runnable jumpTread = new Runnable() {
        @Override
        public void run() {
            if (c_count <= 0) {
                skip();
            } else {
                tv_skip.setText(String.format(SKIP_TEXT, c_count));
                c_count--;
                MobileShopApp.handler.postDelayed(jumpTread, DELAYED);
            }
        }
    };
}
