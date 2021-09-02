package com.itheima.com.itheima.test;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

public class RocketMQSendMessageTest  {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        //1.创建消息生产者，并且设置生产者名、
        DefaultMQProducer producer = new DefaultMQProducer("myproducer");

        //2.为生产者设置NameServer的地址
        producer.setNamesrvAddr("47.92.34.234:9877");

        //3.启动生产者
        producer.start();

        //4.构建消息对象，主要是设置消息的主题，标签，内容
        Message msg = new Message("myTopic", "myTag", ("RocketMQ Message").getBytes());
       // Message msg = new Message("myTopic","myTag",("RocketMQ Message").getBytes());
        //5发送消息
        SendResult sendResult = producer.send(msg , 10000);
        System.out.println(sendResult);
        //6关闭生产者
        producer.shutdown();
    }

}
