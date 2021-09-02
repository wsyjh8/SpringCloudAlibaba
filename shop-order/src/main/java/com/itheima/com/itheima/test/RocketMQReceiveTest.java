package com.itheima.com.itheima.test;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

public class RocketMQReceiveTest {

    public static void main(String[] args) throws MQClientException {

        //1. 创建消息消费者, 指定消费者所属的组名
        //2. 指定Nameserver地址
        //3. 指定消费者订阅的主题和标签
        //4. 设置回调函数，编写处理消息的方法
        //5. 启动消息消费者
        DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer("myonsumer-group");

        defaultMQPushConsumer.setNamesrvAddr("47.92.34.234:9877");

        defaultMQPushConsumer.subscribe("myTopic","*");

        defaultMQPushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.println("Receive New Messages: " + msgs);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        defaultMQPushConsumer.start();

        System.out.println("started");
    }
}
