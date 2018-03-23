package com.zhsy.advancedemo1.ui;

import android.app.WallpaperManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zhsy.advancedemo1.R;
import com.zhsy.advancedemo1.util.WallpaperUtil;

import java.io.IOException;

/**
 * 壁纸开发
 * 1.资源文件做为壁纸
 * 2.Bitmap做为壁纸
 * 3.动态壁纸
 */
public class LiveWallpaperActivity extends AppCompatActivity {
    private final static int REQUEST_CODE_SET_WALLPAPER = 0x001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_wallpaper);
    }
    /**
     * 使用资源文件设置壁纸
     * 直接设置为壁纸，不会有任何界面和弹窗出现
     *
     * @param view
     */
    public void onSetWallpaperForResource(View view) {
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        try {
            wallpaperManager.setResource(R.raw.wallpaper);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //WallpaperManager.FLAG_LOCK  WallpaperManager.FLAG_SYSTEM
//                wallpaperManager.setResource(R.raw.wallpaper, WallpaperManager.FLAG_SYSTEM);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 清除壁纸
     *
     * @param view
     */
    public void clearWallpaper(View view) {
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        try {
            wallpaperManager.clear();
//            clearWallpaper();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onLiveWallpaper(View view) {
        WallpaperUtil.setLiveWallpaper(this.getApplicationContext(), LiveWallpaperActivity.this, LiveWallpaperActivity.REQUEST_CODE_SET_WALLPAPER);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SET_WALLPAPER) {
            if (resultCode == RESULT_OK) {
                // TODO: 2017/3/13 设置动态壁纸成功
            } else {
                // TODO: 2017/3/13 取消设置动态壁纸
            }
        }
    }
}
