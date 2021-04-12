package com.nicholas.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nicholas.entity.Order;
import com.nicholas.mapper.IOrderMapper;
import com.nicholas.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * @Description:  商品接口实现类
 * @Author: denggc3
 * @CreateDate: 2021/4/12$ 16:10$
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/4/12$ 16:10$
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */

@Service("OrderService")
public class OrderServiceImpl extends ServiceImpl<IOrderMapper, Order> implements IOrderService {



}
