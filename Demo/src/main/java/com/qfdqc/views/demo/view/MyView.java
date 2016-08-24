package com.qfdqc.views.demo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;
import com.qfdqc.views.demo.a.UserBean;

import java.util.List;

/**
 * Created by TianHongChun on 2016/8/24.
 */
public class MyView extends View implements View.OnTouchListener,ScaleGestureDetector.OnScaleGestureListener {
    public MyView(Context context) {
        super(context,null);
    }
    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs,defStyleAttr);
    }
    Context context;
    Paint paint;
    List<UserBean> mData;

    ScaleGestureDetector scaleGestureDetector;

    private void init(Context context, AttributeSet attrs, int defStyleAttr){
            this.context=context;
        paint = new Paint();
        paint.setTextSize(40);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth((float)4.0);

        this.setOnTouchListener(this);
    }

    public void setData(List<UserBean> data){
        this.mData=data;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


    int downX,downY;
    int lastX,lastY;
    /**
     * 标识是否正在缩放,缩放时不能移动
     */
    boolean isScaling;
    float scaleX, scaleY;
    /**
     * 是否是第一次缩放
     */
    boolean firstScale = true;
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int y = (int) event.getY();
        int x = (int) event.getX();

        scaleGestureDetector.onTouchEvent(event);

//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                downX = x;
//                downY = y;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                if (!isScaling) {
//                    int downDX = Math.abs(x - downX);
//                    int downDY = Math.abs(y - downY);
//                    if ((downDX > 10 || downDY > 10)) {
//                        int dx = x - lastX;
//                        int dy = y - lastY;
//                        ViewHelper.setTranslationX(this,dx);
//                        ViewHelper.setTranslationY(this,dy);
//                    }
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//                break;
//        }
//        lastY = y;
//        lastX = x;
        return true;
    }

    @Override
    public boolean onScale(ScaleGestureDetector detector) {
        isScaling = true;
        int sc=3;
        float scaleFactor = detector.getScaleFactor();
        if (sc * scaleFactor > 3) {
            scaleFactor = 3 / sc;
        }
        if (firstScale) {
            scaleX = detector.getCurrentSpanX();
            scaleY = detector.getCurrentSpanY();
            firstScale = false;
        }

        if (sc * scaleFactor < 0.5) {
            scaleFactor = 0.5f /sc;
        }
        ViewHelper.setScaleX(this,scaleFactor);
        ViewHelper.setScaleY(this,scaleFactor);
        return true;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        return true;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector detector) {
        isScaling = false;
        firstScale = true;
    }
}
