package com.thc.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by TianHongChun on 2016/9/6.
 */
public class ShopFragment extends Fragment {

    ShopItemView shopItemViewOne;
    ShopItemView shopItemViewTwo;
    ShopItemView shopItemViewThree;
    ShopItemView shopItemViewFour;
    ShopItemView shopItemViewFive;
    ShopItemView shopItemViewSix;
    ShopItemView shopItemViewSenven;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_shop,container,false);
        initView(view);
        return view;
    }
    private void initView(View view){
        shopItemViewOne= (ShopItemView) view.findViewById(R.id.shopItemView_one);
        shopItemViewTwo= (ShopItemView) view.findViewById(R.id.shopItemView_two);
        shopItemViewThree= (ShopItemView) view.findViewById(R.id.shopItemView_three);
        shopItemViewFour= (ShopItemView) view.findViewById(R.id.shopItemView_four);
        shopItemViewFive= (ShopItemView) view.findViewById(R.id.shopItemView_five);
        shopItemViewSix= (ShopItemView) view.findViewById(R.id.shopItemView_six);
        shopItemViewSenven= (ShopItemView) view.findViewById(R.id.shopItemView_seven);

        shopItemViewOne.setMoneyValue("600元");
        shopItemViewOne.setZenValueStr("60");
        shopItemViewOne.setZuanShiValue("30");
    }
}
