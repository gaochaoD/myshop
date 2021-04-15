package com.nicholas;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * @Description: java类作用描述
 * @Author: denggc3
 * @CreateDate: 2021/4/15$ 15:50$
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/4/15$ 15:50$
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
public class ConfirmRecieveConsumer {

    private final static String EXCHANGE_NAME="asynchange";
    private final static String QUEUE="asynqueue";
    private final static String ROUTE_KEY="asynkey";

    public static void excute(String host,int port,String userName,String password){
        //配置连接工厂
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost(host);
        factory.setPort(port);
        factory.setUsername(userName);
        factory.setPassword(password);
        Connection connection=null;
        try{
            //建立TCP连接
            connection=factory.newConnection();
            //在TCP的基础上建立信道
            final Channel channel=connection.createChannel();
            //声明一个topic交换机
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC,true,false,null);
            //声明一个持久化队列
            channel.queueDeclare(QUEUE,true,false,false,null);
            //绑定路由,同一个队列可以绑定多个值
            channel.queueBind(QUEUE,EXCHANGE_NAME,ROUTE_KEY);
            System.out.println("ConfirmRecieveConsumer waiting for message");

            //默认消费者实现
            Consumer consumer=new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                    String msg=new String(body,"utf-8");
                    System.out.println("ConfirmRecieveConsumer Received "+msg);
/*                    //消息正向确认
                    channel.basicAck(envelope.getDeliveryTag(),true);*/
                    //消息否定确认
                    channel.basicNack(envelope.getDeliveryTag(),true,false);
                }
            };

            //接收消息，设置非自动确认
            channel.basicConsume(QUEUE,false,consumer);
            //暂停5s
            Thread.sleep(5*1000);

            channel.close();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //不能执行关闭，如果关闭链接，则后续消息无法收到，无法模拟后续接收消息的情况
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        String IP_ADDRESS="39.104.49.76";
        //RabbitMQ默认服务端口号5672
        int PORT=5672;
        String USER_NAME="root";
        String PASSWORD="root";

        //测试线程池
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        executorService.submit(()->{
           ConfirmRecieveConsumer.excute(IP_ADDRESS,PORT,USER_NAME,PASSWORD);
        });
    }



}
