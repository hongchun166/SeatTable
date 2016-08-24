package com.qfdqc.views.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.qfdqc.views.demo.a.BeanUtils;
import com.qfdqc.views.demo.a.MConstacts;
import com.qfdqc.views.demo.a.UserBean;
import com.qfdqc.views.demo.view.MyView;
import com.qfdqc.views.seattable.UserPojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    MyView myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        myView= (MyView) findViewById(R.id.myView);

        initDataAndItemViewSize();
        BeanUtils util = new BeanUtils();
        util.setData(getData());
        final List<UserBean> list = util.getList();
        util.start(list);
        myView.setData(list);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }

    /**
     * 初始化treeitem的大小
     */
    private void initDataAndItemViewSize(){
        int spce= (int) getResources().getDimension(R.dimen.tree_item_view_spce);
        int w= (int) getResources().getDimension(R.dimen.tree_item_view_width);
        int h= (int) getResources().getDimension(R.dimen.tree_item_view_height);
        int headSmallSize= (int) getResources().getDimension(R.dimen.tree_item_view_head_size_small);
        int headLargeSize= (int) getResources().getDimension(R.dimen.tree_item_view_head_size_large);

        int windownW=getResources().getDisplayMetrics().widthPixels;
        int windownH=getResources().getDisplayMetrics().heightPixels;

        MConstacts.getInstance().setViewSpce(spce);
        MConstacts.getInstance().setViewWidth(w);
        MConstacts.getInstance().setViewHeight(h);
        MConstacts.getInstance().setHeadViewSmallSize(headSmallSize);
        MConstacts.getInstance().setHeadViewLargeSize(headLargeSize);
        MConstacts.getInstance().setWindownWidth(windownW);
        MConstacts.getInstance().setWindownHeight(windownH);
    }

    private ArrayList<UserPojo> getData(){
        ArrayList<UserPojo> arrayList=new ArrayList<>();

        UserPojo userPojo1=new UserPojo("1","0","0","2","爷爷","贾代善");
        UserPojo userPojo2=new UserPojo("2","0","0","1","奶奶","贾母");

        UserPojo userPojo3=new UserPojo("3","1","2","4","父亲","贾政");
        UserPojo userPojo4=new UserPojo("4","20","21","3","母亲","王夫人");

        UserPojo userPojo5=new UserPojo("5","3","4","6","我","贾宝玉");
        UserPojo userPojo6=new UserPojo("6","0","0","5","妻子","薛宝钗");

        UserPojo userPojo7=new UserPojo("7","3","4","0","姐姐","贾元春");
        UserPojo userPojo8=new UserPojo("8","3","4","0","姐姐","贾探春");
        UserPojo userPojo9=new UserPojo("9","3","4","0","哥哥","贾环");
        UserPojo userPojo10=new UserPojo("10","3","4","11","哥哥","贾珠");
        UserPojo userPojo11=new UserPojo("11","0","0","10","嫂子","李织");

        UserPojo userPojo12=new UserPojo("12","10","11","31","侄子","贾兰");


        UserPojo userPojo13=new UserPojo("13","1","2","14","姑姑","贾敏");
        UserPojo userPojo14=new UserPojo("14","0","0","13","姑父","林如海");
        UserPojo userPojo15=new UserPojo("15","13","14","0","表妹","林黛玉");


        UserPojo userPojo16=new UserPojo("16","1","2","17","叔叔","贾郝");
        UserPojo userPojo17=new UserPojo("17","0","0","16","婶婶","刑夫人");
        UserPojo userPojo18=new UserPojo("18","16","17","0","堂哥","贾琏");
        UserPojo userPojo19=new UserPojo("19","16","17","0","堂姐","贾迎春");


        UserPojo userPojo20=new UserPojo("20","0","0","21","姥爷","王姥爷");
        UserPojo userPojo21=new UserPojo("21","0","0","20","姥姥","于姥姥");

        UserPojo userPojo22=new UserPojo("22","20","21","0","舅舅","王子腾");
        UserPojo userPojo23=new UserPojo("23","20","21","24","舅舅","王熙凤");
        UserPojo userPojo24=new UserPojo("24","0","0","23","舅妈","梁舅妈");

        UserPojo userPojo25=new UserPojo("25","23","24","0","表哥","王哥哥");
        UserPojo userPojo26=new UserPojo("26","23","24","0","表妹","王西西");


        UserPojo userPojo27=new UserPojo("27","12","31","32","孩子1","贾兰1");
        UserPojo userPojo28=new UserPojo("28","12","31","0","孩子2","贾兰2");
        UserPojo userPojo29=new UserPojo("29","12","31","33","孩子3","贾兰3");
        UserPojo userPojo30=new UserPojo("30","12","31","34","孩子4","贾兰4");

        UserPojo userPojo31=new UserPojo("31","0","0","12","贾兰媳妇","贾兰媳妇");
        UserPojo userPojo32=new UserPojo("32","0","0","27","孩1媳妇","孩1媳妇");
        UserPojo userPojo33=new UserPojo("33","0","0","29","孩3媳妇","孩3媳妇");
        UserPojo userPojo34=new UserPojo("34","0","0","30","孩4媳妇","孩4媳妇");



        arrayList.add(userPojo1);
        arrayList.add(userPojo2);
        arrayList.add(userPojo3);
        arrayList.add(userPojo4);
        arrayList.add(userPojo5);
        arrayList.add(userPojo6);

        arrayList.add(userPojo7);
        arrayList.add(userPojo8);
        arrayList.add(userPojo9);
        arrayList.add(userPojo10);
        arrayList.add(userPojo11);
        arrayList.add(userPojo12);
        arrayList.add(userPojo13);
        arrayList.add(userPojo14);
        arrayList.add(userPojo15);
        arrayList.add(userPojo16);
        arrayList.add(userPojo17);
        arrayList.add(userPojo18);
        arrayList.add(userPojo19);

//        arrayList.add(userPojo20);
//        arrayList.add(userPojo21);
//        arrayList.add(userPojo22);
//        arrayList.add(userPojo23);
//        arrayList.add(userPojo24);
//        arrayList.add(userPojo25);
//        arrayList.add(userPojo26);
        arrayList.add(userPojo27);
        arrayList.add(userPojo28);
        arrayList.add(userPojo29);
        arrayList.add(userPojo30);
        arrayList.add(userPojo31);
        arrayList.add(userPojo32);
        arrayList.add(userPojo33);
        arrayList.add(userPojo34);

        return arrayList;
    }
}
