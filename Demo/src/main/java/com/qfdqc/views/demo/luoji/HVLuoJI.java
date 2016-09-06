package com.qfdqc.views.demo.luoji;

import android.content.Context;
import android.sax.RootElement;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;
import com.qfdqc.views.demo.view.HVScrollView;

/**
 * Created by TianHongChun on 2016/8/24.
 */
public class HVLuoJI implements ScaleGestureDetector.OnScaleGestureListener,View.OnTouchListener {
    HVScrollView hvScrollView;
    View view;
    ScaleGestureDetector scaleGestureDetector;

    public HVLuoJI(Context context,HVScrollView hvScrollView, View scaView){
        this.hvScrollView=hvScrollView;
        this.view=scaView;
        scaleGestureDetector=new ScaleGestureDetector(context,this);
        hvScrollView.setOnTouchListener(this);
    }

    private void log(String message){
        Log.i(HVLuoJI.class.getName(),""+message);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
//        log("===========onTouch=============");
        scaleGestureDetector.onTouchEvent(event);
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent ev){
        return false;
    }

    float scale=1;
    float lastScale=1;
    boolean isScaleIng=false;
    @Override
    public boolean onScale(ScaleGestureDetector detector) {
        float sf=detector.getScaleFactor();
        log("===========onScale============="+sf);
        if(sf>1){
            scale+=0.01;
        }else if(sf<1){
            scale-=0.01;
        }
        if(isScaleIng){
            if(scale>1.1){
                scale=1.1f;
                isScaleIng=false;
            }else if(scale<0.3){
                scale=0.3F;
                isScaleIng=false;
            }

            ViewHelper.setScaleX(view,scale);
            ViewHelper.setScaleY(view,scale);
            lastScale=scale;
        }
        return true;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        log("===========onScaleBegin=============");
        scale=ViewHelper.getScaleX(view);
        isScaleIng=true;
        return true;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector detector) {
        log("===========onScaleEnd=============");
        scale=lastScale;
        isScaleIng=false;
    }
}
