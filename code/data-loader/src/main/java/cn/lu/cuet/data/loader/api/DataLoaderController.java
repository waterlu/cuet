package cn.lu.cuet.data.loader.api;

import cn.lu.cuet.common.SpringContextUtil;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lu on 16-10-8.
 */
@RestController
public class DataLoaderController {

    @RequestMapping("/")
    public String poll() {
        StringBuffer buffer = new StringBuffer("data received:\n\n");
        PollableChannel channel = SpringContextUtil.getBean("received", PollableChannel.class);
        Message<?> message = channel.receive(1000);
        while(message != null) {
            buffer.append(message.toString());
            buffer.append("\n");
            message = channel.receive(1000);
        }
        return buffer.toString();
    }
}
