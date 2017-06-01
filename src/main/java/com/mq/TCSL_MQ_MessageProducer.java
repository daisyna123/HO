package com.mq;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @DESCRIPTION mq消息生产者
 * @AUTHER administrator zhangna
 * @create 2017-05-05
 */
@Service
public class TCSL_MQ_MessageProducer {
    @Resource
    private AmqpTemplate amqpTemplate;

    //发送消息
    public void sendMessage(Object message){
        amqpTemplate.convertAndSend("exchangeTest","queueTestKey",message);
        System.out.println("发送的消息是:"+message);
    }
}
