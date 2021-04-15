package com.nicholas.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: 订单
 * @Author: denggc3
 * @CreateDate: 2021/4/12$ 15:30$
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/4/12$ 15:30$
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */

@Data
public class Order {
    /**
     * 订单id
     */
    @TableId(value = "orderId",type = IdType.AUTO)
    private int orderId;
    /**
     * 支付金额
     */
    private int payAmount;
    /**
     * 创建时间
     */
    private int createTime;
    /**
     * 支付时间
     */
    private int payTime;
    /**
     * 用户id
     */
    private int userId;
    /**
     * 支付状态 1：未支付；2：已支付；3：已退款
     */
    private int payState;
    /**
     * 收货人地址
     */
    private int cosigneeAddr;
    /**
     * 收货人电话
     */
    private int cosigneePhone;
    /**
     * 收货人姓名
     */
    private int cosigneeName;
    /**
     * 交易流水号
     */
    private int tradeNumber;
    /**
     * 支付类型
     */
    private int payType;
    /**
     * 订单状态
     */
    private int orderState;


}
