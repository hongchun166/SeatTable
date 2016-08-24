package com.qfdqc.views.demo.a;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenshi on 2016/8/20.
 */
public class UserBean {

    private int xWidth = 1; //每次移动的距离

    private int id;
    private int fid;
    private int mid;
    private int sid;
    private String nickName;//对我的昵称
    private String name;//姓名
    private int sex=0;

    private List<UserBean> sons = new ArrayList<>();   //所有的孩子

    private List<UserBean> bros = new ArrayList<>();   //后面的兄弟

    private UserBean father;   //自己的父亲
    
    private UserBean wife;  //自己的爱人

    private int x;
    private int y;


    //添加子节点，自己坐标位置的变化
    public void  changPot(){
        if(sons.size() == 0 || sons.size() == 1){  //所添加孩子为第一个孩子，则坐标不影响
        	
        }else{
            x = (sons.get(0).getX() + sons.get(sons.size()-1).getX())/2;   //不是第一个孩子，说明自己的坐标需要移动，x坐标右移1位
            if( wife!= null){
            	wife.x = x + MConstacts.getInstance().getViewSpce()+MConstacts.getInstance().getViewWidth();
            }
        }
        
    }


    public int getNextPot(){
    	UserBean lastSon = sons.get(sons.size()-1);
    	int jx = lastSon.getX() + MConstacts.getInstance().getViewSpce()+MConstacts.getInstance().getViewWidth();
    	if(lastSon.getWife() != null){
    		jx = jx + MConstacts.getInstance().getViewSpce()+MConstacts.getInstance().getViewWidth();
    	}
    	return jx;
    }

    public UserBean(int id, int fid, int mid, int sid, int x, int y) {
        this.id = id;
        this.fid = fid;
        this.mid = mid;
        this.sid = sid;
        this.x = x;
        this.y = y;
    }

    public UserBean(int id, int fid, int mid, int sid) {
        this.id = id;
        this.fid = fid;
        this.mid = mid;
        this.sid = sid;
    }

    public UserBean(){

    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
    public List<UserBean> getBros() {
        return bros;
    }

    public void setBros(List<UserBean> bros) {
        this.bros = bros;
    }

    public UserBean getFather() {
        return father;
    }

    public void setFather(UserBean father) {
        this.father = father;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public List<UserBean> getSons() {
        return sons;
    }

    public void setSons(List<UserBean> sons) {
        this.sons = sons;
    }


	public UserBean getWife() {
		return wife;
	}


	public void setWife(UserBean wife) {
		this.wife = wife;
	}
    
    
}
