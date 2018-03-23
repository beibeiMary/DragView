package com.zhsy.advancedemo1.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zhsy.advancedemo1.R;

/**
 * Created by zhangshuyang01 on 2018/3/22 0022.
 */

public class MyView extends View {
    private Paint mPaint;
    private Context mContext;
    private static final String mString = "My first View";
    public MyView(Context context){
        super(context);
    }
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyView);
        int textColor = a.getColor(R.styleable.MyView_textColor, Color.RED);
        float textSize = a.getDimension(R.styleable.MyView_textSize,20);
        mPaint.setTextSize(textSize);
        mPaint.setColor(textColor);
        a.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /*mPaint = new Paint();
        //设置画笔的颜色
        mPaint.setColor(Color.RED);*/
        //设置画笔填充
        mPaint.setStyle(Paint.Style.FILL);

        //画一个矩形，前面是矩形左上角坐标，后面是矩形右下角坐标
        canvas.drawRect(new Rect(10,10,100,100),mPaint);
//        mPaint.setColor(Color.YELLOW);
        //绘制文字
        canvas.drawText(mString,10,110,mPaint);

    }
}
