package cn.lu.cuet.data.capture;

import cn.lu.cuet.common.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

/**
 * Created by lu on 16-10-8.
 */
@SpringBootApplication
public class DataCaptureApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(DataCaptureApplication.class).run(args);
        SpringContextUtil.setApplicationContext(context);
    }
}
