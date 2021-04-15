package com.nicholas.controller;


import com.nicholas.entity.Product;
import com.nicholas.received.ReceiveBeanMsgs;
import com.nicholas.send.SendBeanMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: java类作用描述
 * @Author: denggc3
 * @CreateDate: 2021/4/14$ 14:31$
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/4/14$ 14:31$
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */

@RestController
@RequestMapping(value = "rabbit")
public class TestRabbitmq {

    @Autowired
    private SendBeanMsg sendMsg;

    @Autowired
    private ReceiveBeanMsgs receiveMsgs;

   @GetMapping(value = "test1")
    public void test1(String content) {

        sendMsg.send(content);
        try {
            Thread.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @PostMapping(value = "product")
    public void test2(Product product){
       sendMsg.sendMsgConverter(product);
        try {
            Thread.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
