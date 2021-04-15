package com.nicholas;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * @Description: rabbitMq 同步发送消息事务
 * @Author: denggc3
 * @CreateDate: 2021/4/15$ 10:33$
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/4/15$ 10:33$
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
public class TransationSend {

    private static final String EXCHANGE_NAME="exchange1";
    private static final String ROUTE_KEY="routing1";
    private static final String QUEUE_NAME="queue1";

    public static void excute(String host,int port,String username,String password,int num) {

        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost(host);
        factory.setPort(port);
        factory.setUsername(username);
        factory.setPassword(password);
        Connection connection= null;
        Channel channel=null;
        try {
            connection = factory.newConnection();
            //声明一个topic交换机
            channel=connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT,true,false,null);
            String meaaage="TransationSend"+System.currentTimeMillis();
            try {
                //开启事物
                channel.txSelect();
                //发送消息
                while (num-- >0) {
                    //发送一个持久化消息到交换机
                    channel.basicPublish(EXCHANGE_NAME, ROUTE_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN,meaaage.getBytes("utf-8"));
                    System.out.println("TransationSend msg:"+num+" "+meaaage);
                }
/*            if(true){
                throw new IOException("consumer channel.txRollback()");
            }*/
                //提交事物
                channel.txCommit();
            } catch (IOException e) {
                e.printStackTrace();

                //事物回滚
                channel.txRollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
            /**
             * 实际运用中，需要在这添加发送消息失败的处理逻辑，如重发等等
             * 在以上的模式中，如果发送N条消息，如果有一条失败，则所有消息都需要重新推送
             */
        }finally {
            try {
                channel.close();
                connection.close();
            }catch (IOException e){
                e.printStackTrace();
            }catch (TimeoutException e){
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws IOException, TimeoutException {
         String IP_ADDRESS="39.104.49.76";
        //RabbitMQ默认服务端口号5672
         int PORT=5672;
         String USER_NAME="root";
         String PASSWORD="root";


/*        ScheduledExecutorService scheduledExecutorService=new ScheduledThreadPoolExecutor(10);
        scheduledExecutorService.submit(()->{
                TransationSend.excute(IP_ADDRESS,PORT,USER_NAME,PASSWORD,1);

        });*/

        ExecutorService executorService= Executors.newFixedThreadPool(5);
        executorService.submit(()->{
                TransationSend.excute(IP_ADDRESS,PORT,USER_NAME,PASSWORD,5);
        });



    }
}
