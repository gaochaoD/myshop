package com.nicholas.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Description: java类作用描述
 * @Author: denggc3
 * @CreateDate: 2021/4/14$ 9:52$
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/4/14$ 9:52$
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */

@Data
public class OrderDetail {

    /**
     * 订单详情id
     */
    @TableId(value = "Id",type = IdType.AUTO)
    private int Id;
    /**
     * 订单id
     */
    private int order_id;
    /**
     * 商品id
     */
    private int product_id;
    /**
     * 商家id
     */
    private int store_id;
    /**
     * 交易数量
     */
    private int trade_num;
    /**
     * 创建时间
     */
    private int create_time;



}
