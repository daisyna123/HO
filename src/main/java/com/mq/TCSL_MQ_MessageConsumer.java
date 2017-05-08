package com.mq;/**
 * Created by administrator on 2017-05-05.
 */

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @DESCRIPTION mq消息接收类
 * @AUTHER administrator zhangna
 * @create 2017-05-05
 */
public class TCSL_MQ_MessageConsumer implements MessageListener {

    public void onMessage(Message message) {
        System.out.println("接收到data----------:"+message);
    }
}
