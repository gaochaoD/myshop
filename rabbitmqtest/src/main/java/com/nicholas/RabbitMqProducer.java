package com.nicholas;

import com.rabbitmq.client.*;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description: 生产者
 * @Author: denggc3
 * @CreateDate: 2021/4/14$ 10:30$
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/4/14$ 10:30$
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
public class RabbitMqProducer {


    private static final String EXCHANGE_NAME="exchange1";
    private static final String ROUTE_KEY="routing1";
    private static final String QUEUE_NAME="queue1";
    private static final String IP_ADDRESS="39.104.49.76";
    //RabbitMQ默认服务端口号5672
    private static final int PORT=5672;
    private static final String USER_NAME="root";
    private static final String PASSWORD="root";



    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost(IP_ADDRESS);
        factory.setPort(PORT);
        factory.setUsername(USER_NAME);
        factory.setPassword(PASSWORD);
        //建立连接
        Connection connection=factory.newConnection();
        //建立信道
        Channel channel=connection.createChannel();
        //创建一个type=direct,持久化、非自动删除的交换器
        channel.exchangeDeclare(EXCHANGE_NAME,"direct",true,false,null);
        //创建一个持久化、非排他的、非自动删除的队列
        channel.queueDeclare(QUEUE_NAME,true,false,false,null);
        //使用路由将交换器与队列绑定
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,ROUTE_KEY);
        //发送一条持久化的消息
        String message="这是一条持久化消息";
        channel.basicPublish(EXCHANGE_NAME,ROUTE_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());


        channel.close();
        connection.close();



    }


}
