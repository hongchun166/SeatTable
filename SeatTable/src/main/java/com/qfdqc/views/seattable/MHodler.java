package com.qfdqc.views.seattable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TianHongChun on 2016/8/20.
 */
public class MHodler {
    ArrayList<UserPojo> mData;
    UserPojo superUserPojo;
    int maxColumn=0;

    public MHodler(){

    }
    public void setData(UserPojo superUserPojo,ArrayList<UserPojo> data){
        this.mData=data;
        this.superUserPojo=superUserPojo;
        computeMaxColumn(superUserPojo,data);
    }
    public  ArrayList<UserPojo> getData(){
        return mData;
    }
    public UserPojo getSuperUserPojo(){
        return superUserPojo;
    }
    public int getMaxColumn(){
        return maxColumn;

    }

    private void computeMaxColumn(UserPojo superUserPojo,ArrayList<UserPojo> data){
            int indexColumn=0;
            for (int i=0;i<data.size();i++){
                    UserPojo userPojo=data.get(i);
                if(superUserPojo.getId().equals(userPojo.getParentId())){
                    computeMaxColumn(userPojo,getData());
                    indexColumn++;
                }
            }
            if(indexColumn>maxColumn){
                maxColumn=indexColumn;
            }
    }
}
