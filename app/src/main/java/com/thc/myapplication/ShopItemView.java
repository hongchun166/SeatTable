package com.thc.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by TianHongChun on 2016/9/6.
 */
public class ShopItemView extends LinearLayout {
    public ShopItemView(Context context) {
        this(context,null);
    }

    public ShopItemView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ShopItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs,defStyleAttr);
    }

    TextView moneyValueView;
    TextView zuanShiValueView;
    TextView zenValueView;

    private void initView(Context context, AttributeSet attrs, int defStyleAttr){
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.ShopItemView);
       String zuanShiValueStr=typedArray.getString(R.styleable.ShopItemView_zuanshi_value);
        String zenValue=typedArray.getString(R.styleable.ShopItemView_zen_value);
        String moneyValue=typedArray.getString(R.styleable.ShopItemView_money_value);
        typedArray.recycle();

        View view= LayoutInflater.from(context).inflate(R.layout.item_shop,null);
        moneyValueView=(TextView)view.findViewById(R.id.view_money);
        zuanShiValueView=(TextView)view.findViewById(R.id.view_zuanshi_value);
        zenValueView=(TextView)view.findViewById(R.id.view_zen_value);

        moneyValueView.setText(moneyValue);
        zenValueView.setText(zenValue);
        zuanShiValueView.setText(zuanShiValueStr);

        LayoutParams layoutParams=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(view,layoutParams);
    }

    public void setZuanShiValue(String valueStr){
        if(zuanShiValueView!=null)
            zuanShiValueView.setText(valueStr);
    }
    public void setZenValueStr(String valueStr){
        if(zenValueView!=null)
            zenValueView.setText(valueStr);
    }
    public void setMoneyValue(String valueStr){
        if(moneyValueView!=null)
            moneyValueView.setText(valueStr);
    }
}
