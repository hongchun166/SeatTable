package com.qfdqc.views.demo.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nineoldandroids.view.ViewHelper;
import com.qfdqc.views.demo.R;
import com.qfdqc.views.demo.a.MConstacts;
import com.qfdqc.views.demo.a.UserBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TianHongChun on 2016/8/21.
 */
public class MTreeView extends FrameLayout implements View.OnClickListener{

    public MTreeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public MTreeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    Context context;
    List<UserBean> mData;
    Paint paint;
    OnClickListener onTreeOnClickListener;
    View currentSelectView;
    LayoutInflater layoutInflater;

    LinearLayout.LayoutParams smallLayouP;
    LinearLayout.LayoutParams largeLayouP;
    FrameLayout.LayoutParams framenParams;

    RectF soneRectF=new RectF();

    private void init(Context context){
        this.context=context;
        layoutInflater=LayoutInflater.from(context);
        paint = new Paint();
        paint.setTextSize(40);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth((float)4.0);

    }
    public void setData(List<UserBean> data){
        this.mData=data;
        this.removeAllViews();
        addUserPojoView();
        invalidate();
    }
    private void addUserPojoView(){
        smallLayouP=new LinearLayout.LayoutParams(MConstacts.getInstance().getHeadViewSmallSize(),MConstacts.getInstance().getHeadViewSmallSize());
        largeLayouP=new LinearLayout.LayoutParams(MConstacts.getInstance().getHeadViewLargeSize(),MConstacts.getInstance().getHeadViewLargeSize());

        for (int i=0;i<mData.size();i++){
            UserBean userPojo=mData.get(i);
            View view=getAddUserPojoView(userPojo);
            framenParams=new FrameLayout.LayoutParams(MConstacts.getInstance().getViewWidth(),MConstacts.getInstance().getViewHeight());
            framenParams.leftMargin=userPojo.getX();
            framenParams.topMargin=userPojo.getY();
            addView(view,framenParams);
        }
    }
    private View getAddUserPojoView(UserBean userBean){
        View view=layoutInflater.inflate(R.layout.tree_item,null);

        View viewItem=view.findViewById(R.id.view_item);
        ImageView headView= (ImageView) view.findViewById(R.id.view_headView);
        TextView nameView= (TextView) view.findViewById(R.id.view_name);
        TextView nickNameView= (TextView)view.findViewById(R.id.view_nickName);

        int sex=userBean.getSex();
        if(sex==0){
            nickNameView.setBackgroundResource(R.drawable.nick_name_woman_bg);
            nickNameView.setTextColor(Color.parseColor("#bf0000"));
        }else if(sex==1){
            nickNameView.setBackgroundResource(R.drawable.nick_name_man_bg);
            nickNameView.setTextColor(Color.parseColor("#007fff"));
        }
        nameView.setText(userBean.getName());
        nickNameView.setText(userBean.getNickName());

        view.setTag(userBean);
        view.setSelected(false);
        view.setOnClickListener(this);
        return view;
    }
    float samllSac=1F;
    float largeSac=1.2F;
    @Override
    public void onClick(View v) {

        if(currentSelectView!=v){
            if(currentSelectView!=null){
                currentSelectView.setSelected(false);
                ViewHelper.setScaleX(currentSelectView,samllSac);
                ViewHelper.setScaleY(currentSelectView,samllSac);
            }
            ViewHelper.setScaleX(v,largeSac);
            ViewHelper.setScaleY(v,largeSac);
            v.setSelected(true);
            currentSelectView=v;
        }else {

        }
        if(onTreeOnClickListener!=null){
            onTreeOnClickListener.onClick(v);
        }
    }

    public void setOnTreeOnClickListener(OnClickListener onTreeOnClickListener) {
        this.onTreeOnClickListener = onTreeOnClickListener;
    }
    Canvas canvas;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas=canvas;
        for (int i=0;i<mData.size();i++){
            UserBean userPojo=mData.get(i);
            //妻子
            UserBean wifePojo=userPojo.getWife();
            if(wifePojo!=null){
                drawWifeLine(canvas,paint,userPojo,wifePojo);
            }
            //孩子
            List<UserBean> userPojoSons=userPojo.getSons();
            if(userPojoSons!=null && userPojoSons.size()>0){
                drawSoneLine(canvas,paint,userPojo,userPojoSons);
            }
        }
    }
    private void drawWifeLine(Canvas canvas,Paint paint,UserBean userPojo,UserBean wifePojo){
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawLine(
                userPojo.getX()+ MConstacts.getInstance().getViewWidth()/2,
                userPojo.getY()+MConstacts.getInstance().getHeadViewSmallSize()/2+20,
                wifePojo.getX()+MConstacts.getInstance().getViewWidth()/2,
                wifePojo.getY()+MConstacts.getInstance().getHeadViewSmallSize()/2+20,paint);
    }
    private void drawSoneLine(Canvas canvas, Paint paint, UserBean parentUserPojo, List<UserBean> userPojoSons){

        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.FILL);
        int arc=20;

        float parentStartX=parentUserPojo.getX()+MConstacts.getInstance().getViewWidth()/2;
        float parentStartY=parentUserPojo.getY()+MConstacts.getInstance().getViewHeight();
        UserBean parentWifePojo=parentUserPojo.getWife();
        if(parentWifePojo!=null){
            parentStartX=parentUserPojo.getX()+MConstacts.getInstance().getViewWidth()+MConstacts.getInstance().getViewSpce()/2;
            parentStartY=parentUserPojo.getY()+MConstacts.getInstance().getHeadViewSmallSize()/2+20;
            //画夫妻节点
            canvas.drawCircle(parentStartX,parentStartY,12,paint);
        }
        float parentEndX=parentStartX;
        float parentEndY=parentUserPojo.getY()+MConstacts.getInstance().getViewHeight()+MConstacts.getInstance().getViewSpce()/2-arc;

        canvas.drawLine(parentStartX,parentStartY,parentEndX,parentEndY,paint);

        for (UserBean sonPojo:userPojoSons){
            paint.setStyle(Paint.Style.STROKE);//设置实心
            float sonStartX=sonPojo.getX()+MConstacts.getInstance().getViewWidth()/2;
            float sonStartY=sonPojo.getY();
            float sonEndX=sonStartX;
            float sonEndY=sonPojo.getY()-MConstacts.getInstance().getViewSpce()/2+arc;

            Path path1=new Path();
            path1.moveTo(parentStartX,parentStartY);
            path1.lineTo(parentEndX,parentEndY);
              if(arc>0 ||arc<0 ||arc==0){
                if(sonStartX==parentStartX){
                    path1.lineTo(parentEndX,parentEndY);
                    path1.lineTo(sonEndX,sonEndY);
                    path1.lineTo(sonStartX,sonStartY);
                }else if(sonStartX>parentStartX){
                    soneRectF.left=parentEndX;
                    soneRectF.top=parentEndY-arc;
                    soneRectF.right=parentEndX+2*arc;
                    soneRectF.bottom=parentEndY+arc;
                    path1.addArc(soneRectF,180,-90);

                    path1.lineTo(sonEndX-arc,sonEndY-arc);

                    soneRectF.left=sonEndX-2*arc;
                    soneRectF.top=sonEndY-arc;
                    soneRectF.right=sonEndX;
                    soneRectF.bottom=sonEndY+arc;
                    path1.addArc(soneRectF,270,90);
                    path1.lineTo(sonStartX,sonStartY);

                }else if(sonStartX<parentStartX){
                    soneRectF.left=parentEndX-2*arc;
                    soneRectF.top=parentEndY-arc;
                    soneRectF.right=parentEndX;
                    soneRectF.bottom=parentEndY+arc;
                    path1.addArc(soneRectF,0,90);

                    path1.lineTo(sonEndX+arc,sonEndY-arc);

                    soneRectF.left=sonEndX;
                    soneRectF.top=sonEndY-arc;
                    soneRectF.right=sonEndX+2*arc;
                    soneRectF.bottom=sonEndY+arc;
                    path1.addArc(soneRectF,270,-90);
                    path1.lineTo(sonStartX,sonStartY);
                }
              }
            canvas.drawPath(path1, paint);
        }
    }
}
