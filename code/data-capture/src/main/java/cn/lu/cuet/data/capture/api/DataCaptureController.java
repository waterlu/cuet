package cn.lu.cuet.data.capture.api;

import cn.lu.cuet.common.SpringContextUtil;
import cn.lu.cuet.data.capture.DataCaptureApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.support.KafkaNull;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lu on 16-10-8.
 */
@RestController
public class DataCaptureController {

    @RequestMapping("/send/{message}")
    public String send(@PathVariable("message") String body) {
        MessageChannel channel = SpringContextUtil.getBean("kafka-test", MessageChannel.class);
        Message message = new GenericMessage<>(body);
        channel.send(message);
        boolean sent = channel.send(new GenericMessage<>(KafkaNull.INSTANCE));
        return String.valueOf(sent);
    }

}
