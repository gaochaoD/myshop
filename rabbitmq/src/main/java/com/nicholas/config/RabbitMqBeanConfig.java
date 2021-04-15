package com.nicholas.config;

import lombok.Data;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Description: java类作用描述
 * @Author: denggc3
 * @CreateDate: 2021/4/14$ 15:07$
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/4/14$ 15:07$
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */

@Configuration
public class RabbitMqBeanConfig {

    public final static String QUEUE="beanqueue";

    public final static String EXCHANGE="beanexchange";

    public final static String KEY="beankey";

    @Bean
    public Queue queue(){
        return new Queue(QUEUE,true);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queue,TopicExchange exchange){
//        return BindingBuilder.bind(directQueue.);
        return BindingBuilder.bind(queue()).to(exchange).with(KEY);

    }

    /**
     * 定义消息转换实例
     */
    @Bean
    public MessageConverter jackson2JsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
