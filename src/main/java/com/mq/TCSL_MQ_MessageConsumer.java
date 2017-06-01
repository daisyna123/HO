package com.mq;
import net.sf.json.JSONObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

/**
 * @DESCRIPTION mq消息接收类
 * @AUTHER administrator zhangna
 * @create 2017-05-05
 */
public class TCSL_MQ_MessageConsumer implements MessageListener {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    public void onMessage(Message message) {
        byte bytes[] = message.getBody();
        String isoString = null;
        try {
            isoString = new String(bytes,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
       logger.info("接收到data-------"+isoString);
       System.out.println("接收到data----------:"+isoString);
    }
}
