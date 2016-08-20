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
    private String id;
    private String parentId;
    private String   motherId;
    private String  spouseId;

    public UserPojo(){

    }
    public UserPojo(String id,String parentId,String motherId,String spouseId){
            this.id=id;
        this.parentId=parentId;
        this.motherId=motherId;
        this.spouseId=spouseId  ;
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
}
