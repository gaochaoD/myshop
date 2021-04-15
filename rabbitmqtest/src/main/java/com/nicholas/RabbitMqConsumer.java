package com.nicholas;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Description: 消费者
 * @Author: denggc3
 * @CreateDate: 2021/4/14$ 10:56$
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/4/14$ 10:56$
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
public class RabbitMqConsumer {

    private static final String QUEUE_NAME="queue1";
    private static final String IP_ADDRESS="39.104.49.76";
    //RabbitMQ默认服务端口号5672
    private static final int PORT=5672;
    private static final String USER_NAME="root";
    private static final String PASSWORD="root";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        Address[] addresses=new Address[]{
                new Address(IP_ADDRESS,PORT)
    };

        /**
         * 连接方式与生产者连接方式有些不同
         */
        ConnectionFactory factory=new ConnectionFactory();
        factory.setUsername(USER_NAME);
        factory.setPassword(PASSWORD);

        //创建连接
        Connection connection=factory.newConnection(addresses);
        //创建信道
        Channel channel=connection.createChannel();
        //设置客户端最多接受未被ack的消息的个数
        channel.basicQos(64);
        Consumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("receive message:"+new String(body));

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(QUEUE_NAME,consumer);
        //等待回调函数执行完毕后，关闭资源
        TimeUnit.SECONDS.sleep(5);
        channel.close();
        connection.close();
    }

}
