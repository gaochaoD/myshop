package com.nicholas.received;

import com.nicholas.config.RabbitMqBeanConfig;
import com.nicholas.entity.Product;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Description: java类作用描述
 * @Author: denggc3
 * @CreateDate: 2021/4/14$ 15:24$
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/4/14$ 15:24$
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */

@Component
@RabbitListener(queues = RabbitMqBeanConfig.QUEUE)
public class ReceiveBeanMsgs {

    @RabbitHandler
    public void receive(String content){
        System.out.println("receive msg"+content);
    }

    @RabbitHandler
    public void receive(Product product){
        System.out.println("receive msg"+product);
    }


}
