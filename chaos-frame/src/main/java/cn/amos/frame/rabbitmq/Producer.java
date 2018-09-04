package cn.amos.frame.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * PROJECT: chaos <br>
 * DESCRIPTION: notes
 *
 * @author wangdaoyuan
 * @date 2018/9/4
 */
public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setHost("localhost");

        // 建立到代理服务器到连接
        Connection conn = factory.newConnection();
        // 获得信道
        Channel channel = conn.createChannel();

        // 声明交换器
        String exchangeName = "hello-exchange";
        channel.exchangeDeclare(exchangeName, "direct", true);

        String routingKey = "pay";
        // 发布消息
        byte[] messageBodyBytes = "pay success!".getBytes();
        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .type("PAY").contentType("application/json").build();
        channel.basicPublish(exchangeName, routingKey, properties, messageBodyBytes);

        channel.close();
        conn.close();
    }
}
