package lq.study.springboot.demo.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RabbitSender {

    //自动注入RabbitTemplate模板类
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //回调函数: confirm确认
    private final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//            System.err.println("correlationData: " + correlationData);
            String messageId = correlationData.getId();
            if(ack){
                //如果confirm返回成功 则进行更新
                System.out.println(messageId+"成功");
            } else {
                //失败则进行具体的后续操作:重试 或者补偿等手段
                System.err.println("异常处理...");
            }
        }
    };

    @Value("${rabbitmq.userInfo.exchange}")
    private String exchange;
    @Value("${rabbitmq.userInfo.routingKey}")
    private String routingKey;

    //发送消息方法调用: 构建自定义对象消息
    public void send(byte[] body){
        rabbitTemplate.setConfirmCallback(confirmCallback);
        //消息唯一ID
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        //参数：交换器 路由key 消息体 消息唯一ID
        MessageProperties messageProperties = new MessageProperties();
        Message message = new Message(body,messageProperties);
        rabbitTemplate.send(exchange, routingKey, message, correlationData);
    }

}
