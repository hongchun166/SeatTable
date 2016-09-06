package com.qfdqc.views.demo.a;

import android.text.TextUtils;
import android.util.Log;

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


    int widhtSpace=0;
    int heigthSpace=0;
    public void start(List<UserBean> list){

        widhtSpace=MConstacts.getInstance().getViewWidth()+MConstacts.getInstance().getViewSpce();
        heigthSpace=MConstacts.getInstance().getViewHeight()+MConstacts.getInstance().getViewSpce();

        UserBean rootBean = list.get(0);
        int startX=100;
        int startY=100;
        rootBean.setX(startX);
        rootBean.setY(startY);
        UserBean w = map.get(rootBean.getSid());
        if(w!=null){
            w.setX(rootBean.getX() +widhtSpace);
            w.setY(rootBean.getY());
            rootBean.setWife(w);
        }
        calcPot2222222222(list,rootBean);
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
                    int lastSonX=getNextPot(rootBean);
                    if(lastSonX < xMax){
                        ub.setX(xMax);
                    }else{
                        ub.setX(lastSonX);
                    }
                }
                ub.setY(rootBean.getY() +heigthSpace);
                ub.setFather(rootBean);
                rootBean.getSons().add(ub);

                if(ub.getSid() != 0){
                    UserBean w = map.get(ub.getSid());
                    w.setX(ub.getX() + widhtSpace);
                    w.setY(ub.getY());
                    ub.setWife(w);
                }
                if(ub.getX() >= xMax){
                    xMax = ub.getX() + widhtSpace;
                }
                calcPot(list,ub);
            }
        }

        chanPot(rootBean);

        if(rootBean.getSons().size() != 0){
            if(getNextPot(rootBean)> xMax){
                xMax = getNextPot(rootBean);
            }
        }
        if(rootBean.getWife() != null){
            if(rootBean.getWife().getX() > xMax){
                xMax = rootBean.getWife().getX() + widhtSpace;
            }
        }
    }
    public void calcPot2222222222(List<UserBean> list,UserBean rootBean){
        int rootId = rootBean.getId();
        for(int i = 0;i<list.size();i++){
            UserBean ub = list.get(i);
            if(ub.getFid() == rootId){
                if(rootBean.getSons().size() == 0){
                    ub.setX(rootBean.getX());
                }else{
                    int lastSonX=getNextPot(rootBean);
                    if(lastSonX < xMax){
                        ub.setX(xMax);
                    }else{
                        ub.setX(lastSonX);
                    }
                }
                ub.setY(rootBean.getY() +heigthSpace);
                ub.setFather(rootBean);
                rootBean.getSons().add(ub);

                if(ub.getSid() != 0){
                    UserBean w = map.get(ub.getSid());
                    w.setX(ub.getX() + widhtSpace);
                    w.setY(ub.getY());
                    ub.setWife(w);
                }
                if(ub.getX() >= xMax){
                    xMax = ub.getX() + widhtSpace;
                }
                calcPot(list,ub);
            }
        }
        chanPot(rootBean);
    }

    /**
     * 获取最后一个孩子的X坐标值,孩子有伴侣就获取伴侣的
     * @param userBean
     */
    private int getNextPot(UserBean userBean){
        UserBean lastSon = userBean.getSons().get(userBean.getSons().size()-1);
        int jx = lastSon.getX() +widhtSpace;
        if(lastSon.getWife() != null){
            jx = jx + widhtSpace;
        }
        return jx;
    }
    /**
     * 子类坐标算完后，再次计算父类的坐标,到子类中间
     * @param userBean
     */
    private void chanPot(UserBean userBean){
        //添加子节点，自己坐标位置的变化
            if(userBean.getSons().size() == 0 ){  //所添加孩子为第一个孩子，则坐标不影响
            }else {
               int x = (userBean.getSons().get(0).getX() + userBean.getSons().get(userBean.getSons().size()-1).getX())/2;   //不是第一个孩子，说明自己的坐标需要移动，x坐标右移1位
                userBean.setX(x);
                UserBean wife=userBean.getWife();
                if( wife!= null){
                    wife.setX(x+widhtSpace);
                }
            }
    }

}
