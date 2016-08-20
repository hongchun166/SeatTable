package com.qfdqc.views.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.qfdqc.views.seattable.MHodler;
import com.qfdqc.views.seattable.SeatTable;
import com.qfdqc.views.seattable.UserPojo;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {
    SeatTable seatTableView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        seatTableView= (SeatTable) findViewById(R.id.seatView);

        seatTableView.setScreenName("8号厅荧幕");//设置屏幕名称
        seatTableView.setMaxSelected(3);//设置最多选中
        seatTableView.setSeatChecker(new SeatTable.SeatChecker() {
            @Override
            public boolean isValidSeat(int row, int column) {
                if(column==2) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean isSold(int row, int column) {
                if(row==6&&column==6){
                    return true;
                }
                return false;
            }

            @Override
            public void checked(int row, int column) {

            }

            @Override
            public void unCheck(int row, int column) {

            }

            @Override
            public String[] checkedSeatTxt(int row, int column) {
                return null;
            }

        });
        seatTableView.setData(10,10);
        MHodler hodler=new MHodler();
        hodler.setData(getSuperUser(),getData());
        Log.i(TestActivity.class.getName(),"========="+hodler.getMaxColumn());
    }

    private UserPojo getSuperUser(){
        UserPojo userPojo1=new UserPojo("1","0","0","2");
        return userPojo1;
    }
    private ArrayList<UserPojo> getData(){
        ArrayList<UserPojo> arrayList=new ArrayList<>();

//        UserPojo userPojo1=new UserPojo("1","0","0","2");
        UserPojo userPojo2=new UserPojo("2","0","0","1");

        UserPojo userPojo3=new UserPojo("3","1","2","6");
        UserPojo userPojo4=new UserPojo("4","1","2","0");
        UserPojo userPojo5=new UserPojo("5","1","2","7");
        UserPojo userPojo6=new UserPojo("6","0","0","3");
        UserPojo userPojo7=new UserPojo("7","0","0","5");
        UserPojo userPojo8=new UserPojo("8","3","6","11");
        UserPojo userPojo9=new UserPojo("9","3","6","12");
        UserPojo userPojo10=new UserPojo("10","3","6","13");
        UserPojo userPojo11=new UserPojo("11","0","0","8");
        UserPojo userPojo12=new UserPojo("12","0","0","9");
        UserPojo userPojo13=new UserPojo("13","0","0","10");
        UserPojo userPojo14=new UserPojo("14","5","7","0");
        UserPojo userPojo15=new UserPojo("15","3","6","0");

//        arrayList.add(userPojo1);
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

        return arrayList;
    }
}
