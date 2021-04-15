package com.nicholas;

import com.rabbitmq.client.*;
import java.io.IOException;
import java.util.concurrent.*;

/**
 * @Description: 异步发送消息事务
 * @Author: denggc3
 * @CreateDate: 2021/4/15$ 15:09$
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/4/15$ 15:09$
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */

public class AsynConfirmSend {

    private final static String EXCHANGE_NAME="asynchange";
    private final static String QUEUE="asynqueue";
    private final static String ROUTE_KEY="asynkey";


    public static void excute(String host,int port,String userName,String password,int num){

        //配置连接工厂
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost(host);
        factory.setPort(port);
        factory.setUsername(userName);
        factory.setPassword(password);
        Connection connection=null;
        Channel channel=null;
        try {
            //建立TCP连接
            connection=factory.newConnection();
            //在TCP连接的基础上创建通道
            channel=connection.createChannel();
            //声明交换机
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC,true,false,null);
            //创建一个持久化、非排他的、非自动删除的队列
            channel.queueDeclare(QUEUE,true,false,false,null);
            String msg="asyn meaagse:"+System.currentTimeMillis();

            channel.addConfirmListener(new ConfirmListener() {
                //成功
                @Override
                public void handleAck(long l, boolean b) throws IOException {
                    System.out.println("AsynConfirmSend handleAck:"+" "+"deliveryTag "+l+" multiple "+b);
                }

                //失败
                @Override
                public void handleNack(long l, boolean b) throws IOException {
                    System.out.println("AsynConfirmSend handleNack:"+" "+"deliveryTag "+l+" multiple "+b);
                }
            });

            //开启confirm模式
            channel.confirmSelect();
            //发送消息
            while (num-->0) {
                //发送一个持久化的消息到特定的交换机
                channel.basicPublish(EXCHANGE_NAME, ROUTE_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, msg.getBytes("utf-8"));
                System.out.println("AsynConfirmSend:"+num+" "+msg);
            }

            //等待消息的回执
            Thread.sleep(1*1000);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                channel.close();
                connection.close();
            }catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
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

        ExecutorService executorService= Executors.newFixedThreadPool(2);
        executorService.submit(()->{
            AsynConfirmSend.excute(IP_ADDRESS,PORT,USER_NAME,PASSWORD,2);
        });


    }



}
