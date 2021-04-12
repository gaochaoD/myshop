package com.nicholas.enums;

/**
 * @Description:  商品状态枚举类
 * @Author: denggc3
 * @CreateDate: 2021/4/12$ 15:46$
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/4/12$ 15:46$
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */

public enum ProductStateEnum {

    TOBE_PUT(1,"未上架"),
    ON_PUT(2,"正在上架"),
    APPROVED_PUT(3,"已上架"),
    FAIL_PUT(4,"上架失败");


    ProductStateEnum(int state,String message){
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
