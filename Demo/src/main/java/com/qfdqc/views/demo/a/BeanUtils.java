package com.qfdqc.views.demo.a;

import android.text.TextUtils;

import com.qfdqc.views.seattable.UserPojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wenshi on 2016/8/20.
 */
public class BeanUtils {
    public Map<Integer,UserBean> map = new HashMap();
    private List<UserBean> list = new ArrayList<>();
    public List<UserBean> getList(){
//        UserBean ub = new UserBean();
//        ub.setId(1);
//        ub.setFid(0);
//        ub.setMid(0);
//        ub.setSid(2);
//        list.add(ub);
//        map.put(ub.getId(), ub);
//
//        ub = new UserBean();
//        ub.setId(2);
//        ub.setFid(0);
//        ub.setMid(0);
//        ub.setSid(1);
//        list.add(ub);
//        map.put(ub.getId(), ub);
//
//        ub = new UserBean();
//        ub.setId(3);
//        ub.setFid(1);
//        ub.setMid(2);
//        ub.setSid(6);
//        list.add(ub);
//        map.put(ub.getId(), ub);
//
//        ub = new UserBean();
//        ub.setId(4);
//        ub.setFid(1);
//        ub.setMid(2);
//        ub.setSid(0);
//        list.add(ub);
//        map.put(ub.getId(), ub);
//
//        ub = new UserBean();
//        ub.setId(5);
//        ub.setFid(1);
//        ub.setMid(2);
//        ub.setSid(7);
//        list.add(ub);
//        map.put(ub.getId(), ub);
//
//        ub = new UserBean();
//        ub.setId(6);
//        ub.setFid(0);
//        ub.setMid(0);
//        ub.setSid(3);
//        list.add(ub);
//        map.put(ub.getId(), ub);
//
//        ub = new UserBean();
//        ub.setId(7);
//        ub.setFid(0);
//        ub.setMid(0);
//        ub.setSid(5);
//        list.add(ub);
//        map.put(ub.getId(), ub);
//
//        ub = new UserBean();
//        ub.setId(8);
//        ub.setFid(3);
//        ub.setMid(6);
//        ub.setSid(11);
//        list.add(ub);
//        map.put(ub.getId(), ub);
//
//        ub = new UserBean();
//        ub.setId(9);
//        ub.setFid(3);
//        ub.setMid(6);
//        ub.setSid(12);
//        list.add(ub);
//        map.put(ub.getId(), ub);
//
//        ub = new UserBean();
//        ub.setId(10);
//        ub.setFid(3);
//        ub.setMid(6);
//        ub.setSid(13);
//        list.add(ub);
//        map.put(ub.getId(), ub);
//
//        ub = new UserBean();
//        ub.setId(11);
//        ub.setFid(0);
//        ub.setMid(0);
//        ub.setSid(8);
//        list.add(ub);
//        map.put(ub.getId(), ub);
//
//        ub = new UserBean();
//        ub.setId(12);
//        ub.setFid(0);
//        ub.setMid(0);
//        ub.setSid(9);
//        list.add(ub);
//        map.put(ub.getId(), ub);
//
//        ub = new UserBean();
//        ub.setId(13);
//        ub.setFid(0);
//        ub.setMid(0);
//        ub.setSid(10);
//        list.add(ub);
//        map.put(ub.getId(), ub);
//
//        ub = new UserBean();
//        ub.setId(14);
//        ub.setFid(5);
//        ub.setMid(7);
//        ub.setSid(0);
//        list.add(ub);
//        map.put(ub.getId(), ub);
//
//        ub = new UserBean();
//        ub.setId(15);
//        ub.setFid(9);
//        ub.setMid(12);
//        ub.setSid(0);
//        list.add(ub);
//        map.put(ub.getId(), ub);
//
//        ub = new UserBean();
//        ub.setId(16);
//        ub.setFid(9);
//        ub.setMid(12);
//        ub.setSid(0);
//        list.add(ub);
//        map.put(ub.getId(), ub);
//
//        ub = new UserBean();
//        ub.setId(17);
//        ub.setFid(10);
//        ub.setMid(13);
//        ub.setSid(0);
//        list.add(ub);
//        map.put(ub.getId(), ub);

        return list;
    }
    public void setData(ArrayList<UserPojo> data){
        UserBean ub;
        for (UserPojo userPojo:data){
            ub = new UserBean();
            ub.setId( TextUtils.isEmpty(userPojo.getId()) ? 0:Integer.valueOf(userPojo.getId()));
            ub.setFid( TextUtils.isEmpty(userPojo.getParentId()) ? 0: Integer.valueOf(userPojo.getParentId()) );
            ub.setMid( TextUtils.isEmpty(userPojo.getMotherId()) ? 0:Integer.valueOf(userPojo.getMotherId()));
            ub.setSid( TextUtils.isEmpty(userPojo.getSpouseId()) ? 0:Integer.valueOf(userPojo.getSpouseId()));
            ub.setSex(userPojo.getSex());
            ub.setNickName(userPojo.getNickName());
            ub.setName(userPojo.getName());
            list.add(ub);
            map.put(ub.getId(), ub);
        }
    }

    public int getCols(List<UserBean> list,UserBean rootBean){
        int col = 0;
        int rootId = rootBean.getId();
        for(int i = 0;i<list.size();i++){
            UserBean ub = list.get(i);
            if(ub.getFid() == rootId){
                rootBean.getSons().add(ub);
                if(col == 0){
                    col = 1;
                }else{
                    col += 2;
                }
                if(ub.getSid() != 0){
                    col += 2;
                }
            }
        }
        return col;
    }



    public void start(List<UserBean> list){
        UserBean rootBean = list.get(0);
        int startX=MConstacts.getInstance().getWindownWidth()/2;
        int startY=100;
        UserBean w = map.get(rootBean.getSid());
        if(w!=null){
            startX=MConstacts.getInstance().getWindownWidth()/2-MConstacts.getInstance().getViewWidth()-MConstacts.getInstance().getViewSpce()/2;
            rootBean.setX(startX);
            rootBean.setY(startY);

            w.setX(rootBean.getX() + MConstacts.getInstance().getViewSpce()+MConstacts.getInstance().getViewWidth());
            w.setY(rootBean.getY());
            rootBean.setWife(w);
        }else {
            rootBean.setX(startX);
            rootBean.setY(startY);
        }

        calcPot(list,rootBean);
        for (int i = 0;i<list.size();i++){
            UserBean bean = list.get(i);
            System.out.println(bean.getId() + "-" + bean.getX() + "-" + bean.getY()+"-"+bean.getNickName()+"-"+bean.getName());
        }
    }

    public int xMax = 0;
    public int deep[] = new int[20];
    public void calcPot(List<UserBean> list,UserBean rootBean){
        int rootId = rootBean.getId();
        for(int i = 0;i<list.size();i++){
            UserBean ub = list.get(i);
            if(ub.getFid() == rootId){
                if(rootBean.getSons().size() == 0){
                    ub.setX(rootBean.getX());
                }else{
                    if((rootBean.getNextPot()) < xMax){
                        ub.setX(xMax);
                    }else{
                        ub.setX(rootBean.getNextPot());
                    }

                }

                ub.setY(rootBean.getY() +MConstacts.getInstance().getViewSpce()+MConstacts.getInstance().getViewHeight());
                ub.setFather(rootBean);
                rootBean.getSons().add(ub);

                if(ub.getSid() != 0){
                    UserBean w = map.get(ub.getSid());
                    w.setX(ub.getX() + MConstacts.getInstance().getViewSpce()+MConstacts.getInstance().getViewWidth());
                    w.setY(ub.getY());
                    ub.setWife(w);
//                    if(w.getX() >= xMax){
//                        xMax = w.getX() + 2;
//                    }
                }

                if(ub.getX() >= xMax){
                    xMax = ub.getX() + MConstacts.getInstance().getViewSpce()+MConstacts.getInstance().getViewWidth();
                }

                calcPot(list,ub);
            }
        }
        rootBean.changPot();

        if(rootBean.getSons().size() != 0){
            if(rootBean.getNextPot() > xMax){
                xMax = rootBean.getNextPot();
            }
        }
        if(rootBean.getWife() != null){
            if(rootBean.getWife().getX() > xMax){
                xMax = rootBean.getWife().getX() + MConstacts.getInstance().getViewSpce()+MConstacts.getInstance().getViewWidth();
            }
        }
    }
}
