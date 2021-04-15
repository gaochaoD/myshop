/*
package com.nicholas.send;


import com.nicholas.config.RabbitMqConfig;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

*/
/**
 * @Description: java类作用描述
 * @Author: denggc3
 * @CreateDate: 2021/4/14$ 14:08$
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/4/14$ 14:08$
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 *//*


@Component
public class SendMsg {

    */
/**
     * 此接口默认只有一个实现，且是RabbitAdmin,通过源码发现其内部实现实际是RabbitTemplate,
     * 所以AmqpAdmin和AmqpTemplate当前两者本质是相同的
     *//*

    @Autowired
    private AmqpAdmin amqpAdmin;

    */
/**
     * 此接口默认实现是RabbitTemplate,目前只有一个实现
     *//*

    @Autowired
    private AmqpTemplate amqpTemplate;


    */
/**
     * 发送消息
     * @param msg
     *//*

    public void send(String  msg){
        amqpTemplate.convertAndSend(RabbitMqConfig.EXCHANGE,RabbitMqConfig.KEY,msg);
    }

}
*/
