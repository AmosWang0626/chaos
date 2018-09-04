package cn.amos.frame.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * PROJECT: chaos <br>
 * DESCRIPTION: notes
 *
 * @author wangdaoyuan
 * @date 2018/9/4
 */
public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接工厂 || 以下三个参数都是默认值
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setHost("localhost");

        // 建立到代理服务器到连接
        Connection conn = factory.newConnection();
        // 获得信道
        final Channel channel = conn.createChannel();

        // 声明交换器
        String exchangeName = "hello-exchange";
        channel.exchangeDeclare(exchangeName, "direct", true);

        // 声明队列
        String queueName = channel.queueDeclare().getQueue();
        String routingKey = "pay";
        // 通过路由键 pay 将队列和交换器绑定起来
        channel.queueBind(queueName, exchangeName, routingKey);

        while (true) {
            // 消费消息
            boolean autoAck = false;

            String consumerTag = "";
            channel.basicConsume(queueName, autoAck, consumerTag, new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String routingKey = envelope.getRoutingKey();

                    System.out.println("消费的路由键：" + routingKey);
                    System.out.println("消费的类型：" + properties.getType());
                    System.out.println("消费的内容类型：" + properties.getContentType());

                    long deliveryTag = envelope.getDeliveryTag();
                    // 确认消息
                    channel.basicAck(deliveryTag, false);

                    String bodyStr = new String(body, StandardCharsets.UTF_8);
                    System.out.println("消费的消息体内容：" + bodyStr);
                }
            });
        }
    }
}
