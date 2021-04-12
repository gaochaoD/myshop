package com.nicholas.enums;

/**
 * @Description: 商品审核状态枚举类
 * @Author: denggc3
 * @CreateDate: 2021/4/12$ 15:41$
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/4/12$ 15:41$
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */

public enum ProductAuditStateEnum {

    TOBE_AUDIT(1,"待审核"),
    ON_AUDIT(2,"审核中"),
    APPROVED_AUDIT(3,"审核通过"),
    FAIL_AUDIT(4,"审核不通过");


    ProductAuditStateEnum(int state,String message){
        this.state=state;
        this.message=message;
    }

    private int state;

    private String message;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
