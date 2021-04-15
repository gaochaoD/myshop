package com.nicholas.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: 商品
 * @Author: denggc3
 * @CreateDate: 2021/4/12$ 15:30$
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/4/12$ 15:30$
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */

@Data
public class Product implements Serializable {

    /**
     * 商品主键
     */
    private int id;
    /**
     * 商品类别id
     */
    private int productTypeId;
    /**
     * 商品标题
     */
    private String productTitle;
    /**
     * 商品价格
     */
    private BigDecimal productPrice;
    /**
     * 商品图片地址
     */
    private String productImgUrl;
    /**
     * 商品状态  1：未上架   2：上架中；3：已上架；4：上架失败
     */
    private int productStatus;
    /**
     * 商家id
     */
    private int storeId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 审核时间
     */
    private Date auditTime;
    /**
     * 商品审核状态   1：待审核；2：审核中；3：审核通过；4：审核不通过；
     */
    private int auditState;
    /**
     * 库存数量
     */
    private int stockNum;
    /**
     * 销售数量
     */
    private int saleNum;



}
