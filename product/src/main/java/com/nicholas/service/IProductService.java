package com.nicholas.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.nicholas.entity.Product;

import java.util.List;

/**
 * @Description: 商品接口
 * @Author: denggc3
 * @CreateDate: 2021/4/12$ 16:08$
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/4/12$ 16:08$
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */

public interface IProductService extends IService<Product> {

    List<Product> getAll();


}
