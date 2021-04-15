/*
package com.nicholas.received;

import com.nicholas.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


*/
/**
 * @Description: java类作用描述
 * @Author: denggc3
 * @CreateDate: 2021/4/14$ 14:15$
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/4/14$ 14:15$
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 *//*

@Component
public class ReceiveMsgs {

    @RabbitListener(containerFactory = "rabbitListenerContainerFactory",
    bindings = @QueueBinding(value = @Queue(value = RabbitMqConfig.QUEUE+"3",durable = "true",autoDelete = "true"),
            exchange = @Exchange(value = RabbitMqConfig.EXCHANGE,type ="direct" ),
            key = RabbitMqConfig.KEY
    ))
    public void receive(String content){
        System.out.println("receive msg"+content);
    }
}
*/
