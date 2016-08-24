package com.qfdqc.views.demo.a;

/**
 * Created by TianHongChun on 2016/8/23.
 */
public class MConstacts {
    public   int viewSpce=0;
    public   int viewWidth=0;
    public   int viewHeight=0;

    private int headViewSmallSize=0;
    private int headViewLargeSize=0;
    private int windownWidth=0;
    private int windownHeight=0;

    private static   MConstacts instance;
    public static MConstacts getInstance(){
            if(instance==null){
                instance=new MConstacts();
            }
        return instance;
    }

    public int getViewSpce() {
        return viewSpce;
    }

    public void setViewSpce(int viewSpce) {
        this.viewSpce = viewSpce;
    }

    public int getViewWidth() {
        return viewWidth;
    }

    public void setViewWidth(int viewWidth) {
        this.viewWidth = viewWidth;
    }

    public int getViewHeight() {
        return viewHeight;
    }

    public void setViewHeight(int viewHeight) {
        this.viewHeight = viewHeight;
    }

    public int getHeadViewSmallSize() {
        return headViewSmallSize;
    }

    public void setHeadViewSmallSize(int headViewSmallSize) {
        this.headViewSmallSize = headViewSmallSize;
    }

    public int getHeadViewLargeSize() {
        return headViewLargeSize;
    }

    public void setHeadViewLargeSize(int headViewLargeSize) {
        this.headViewLargeSize = headViewLargeSize;
    }

    public int getWindownWidth() {
        return windownWidth;
    }

    public void setWindownWidth(int windownWidth) {
        this.windownWidth = windownWidth;
    }

    public int getWindownHeight() {
        return windownHeight;
    }

    public void setWindownHeight(int windownHeight) {
        this.windownHeight = windownHeight;
    }
}
