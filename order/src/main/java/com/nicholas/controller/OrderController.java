package com.nicholas.controller;

import com.nicholas.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping(value = "order")
public class OrderController {

    @Autowired
    private IOrderService orderService;


    @GetMapping(value = "/demo")
    public String demo(){
        return "demo";
    }






}
