package cn.lu.cuet.data.loader;

import cn.lu.cuet.common.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;

/**
 * Created by lu on 16-10-8.
 */
@SpringBootApplication
public class DataLoaderApplication {
    public static void main(String[] args) {
//        SpringApplication.run(DataLoaderApplication.class, args);
        ConfigurableApplicationContext context = new SpringApplicationBuilder(DataLoaderApplication.class).run(args);
//        SpringContextUtil.setApplicationContext(context);

        PollableChannel channel = context.getBean("received", PollableChannel.class);
        Message<?> message = channel.receive(1000);
        while(true) {
            System.out.println(message);
            message = channel.receive(1000);
        }
    }
}
