package com.nicholas.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nicholas.config.RedisService;
import com.nicholas.entity.Product;
import com.nicholas.model.ProductModel;
import com.nicholas.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @Autowired
    private RedisService redisService;


    @GetMapping(value = "/demo")
    public String demo(){
        redisService.setStr("test","test");
        return "demo";
    }


    @PostMapping(value = "insert")
    public Product insert(ProductModel productModel){

        Product product = JSON.parseObject(JSON.toJSONString(productModel), Product.class);

        productService.save(product);

        redisService.setStr(String.valueOf(product.getId()), String.valueOf(product));

        return product;
    }


    @PostMapping(value = "save")
    public Product save(ProductModel productModel){

        Product product=new Product();
        BeanUtils.copyProperties(productModel, product);
        productService.save(product);
        return product;


    }

    @GetMapping(value = "getById")
    public Product getById(int id){
        Product product=null;
        if(redisService.getStr(String.valueOf(id))!=null){
            System.out.println("从缓存获取");
            String jsonStr=redisService.getStr(String.valueOf(id));
            product=JSONObject.parseObject(jsonStr,Product.class);
        }else {
            System.out.println("从数据库中获取");
            product=productService.getById(id);
            String jsonStr = JSONObject.toJSONString(product);
            redisService.setStr(String.valueOf(id),jsonStr);
        }
        return product;
    }


    @GetMapping(value = "get")
    public List<Product> getList(){
        return productService.list();
    }


    @GetMapping(value = "getAll")
    public List<Product> getAll(){
        return productService.getAll();
    }


}
