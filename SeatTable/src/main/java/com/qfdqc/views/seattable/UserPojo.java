package com.qfdqc.views.seattable;

/**
 * Created by TianHongChun on 2016/8/20.
 */
public class UserPojo {
//    用户一ID  父亲ID   母亲ID   妻子|丈夫ID
//    用户二ID  父亲ID   母亲ID   妻子|丈夫ID
//    用户三ID  父亲ID   母亲ID   妻子|丈夫ID
//    用户四ID  父亲ID   母亲ID   妻子|丈夫ID
//    用户五ID  父亲ID   母亲ID   妻子|丈夫ID
//    用户六ID  父亲ID   母亲ID   妻子|丈夫ID 伴侣
    public static final int SEX_MAN=1;
    public static final int SEX_WOMAN=0;
    private String id;
    private String parentId;//父亲ID
    private String   motherId;//母亲ID
    private String  spouseId;//伴侣ID
    private String nickName;//对我的昵称
    private String name;//姓名
    private int sex=0;

    private float x;
    private float y;
    private float z;

    public UserPojo(){

    }
    public UserPojo(String id,String parentId,String motherId,String spouseId,String nickName,String name){
        this.id=id;
        this.parentId=parentId;
        this.motherId=motherId;
        this.spouseId=spouseId  ;
        this.nickName=nickName;
        this.name=name;
    }
    public UserPojo(String id,String parentId,String motherId,String spouseId,String nickName,String name,int sex){
            this.id=id;
        this.parentId=parentId;
        this.motherId=motherId;
        this.spouseId=spouseId  ;
        this.nickName=nickName;
        this.name=name;
        this.sex=sex;
    }
    public UserPojo(String id,String parentId,String motherId,String spouseId,String nickName,String name,float x,float y){
        this.id=id;
        this.parentId=parentId;
        this.motherId=motherId;
        this.spouseId=spouseId  ;
        this.nickName=nickName;
        this.name=name;
        this.x=x;
        this.y=y;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getMotherId() {
        return motherId;
    }

    public void setMotherId(String motherId) {
        this.motherId = motherId;
    }

    public String getSpouseId() {
        return spouseId;
    }

    public void setSpouseId(String spouseId) {
        this.spouseId = spouseId;
    }

    @Override
    public String toString() {
        return "UserPojo{" +
                "id='" + id + '\'' +
                ", nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
