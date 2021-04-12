package com.nicholas.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nicholas.entity.Product;
import com.nicholas.mapper.IProductMapper;
import com.nicholas.service.IProductService;
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

@Service("ProductService")
public class ProductServiceImpl extends ServiceImpl<IProductMapper,Product> implements IProductService {



}
