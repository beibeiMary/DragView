package com.zhsy.advancedemo1.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zhsy.advancedemo1.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_DragActivity;
    private Button btn_LiveWallpaperActivity;
    private Button btn_MyViewActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        btn_DragActivity = findViewById(R.id.btn_DragActivity);
        btn_DragActivity.setOnClickListener(this);
        btn_LiveWallpaperActivity = findViewById(R.id.btn_LiveWallpaperActivity);
        btn_LiveWallpaperActivity.setOnClickListener(this);
        btn_MyViewActivity = findViewById(R.id.btn_MyViewActivity);
        btn_MyViewActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_DragActivity:
                startActivity(new Intent(this,DragActivity.class));
                break;
            case R.id.btn_LiveWallpaperActivity:
                startActivity(new Intent(this,LiveWallpaperActivity.class));
                break;
            case R.id.btn_MyViewActivity:
                startActivity(new Intent(this,MyViewActivity.class));
                break;
        }
    }
}
