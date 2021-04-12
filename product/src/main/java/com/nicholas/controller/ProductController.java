package com.nicholas.controller;

import com.nicholas.entity.Product;
import com.nicholas.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: ProductController
 * @Author: denggc3
 * @CreateDate: 2021/4/12$ 15:53$
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/4/12$ 15:53$
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */

@RestController
@RequestMapping(value = "product")
public class ProductController {

    @Autowired
    private IProductService productService;


    @GetMapping(value = "/demo")
    public String demo(){
        return "demo";
    }

    @GetMapping(value = "insert")
    public int insert(){
        Product product=new Product();
        product.setProductTitle("测试");

        productService.save(product);


        return product.getId();
    }




}
