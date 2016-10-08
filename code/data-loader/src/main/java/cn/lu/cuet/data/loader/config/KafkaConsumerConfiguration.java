package cn.lu.cuet.data.loader.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.kafka.inbound.KafkaMessageDrivenChannelAdapter;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.config.ContainerProperties;
import org.springframework.kafka.support.TopicPartitionInitialOffset;
import org.springframework.messaging.PollableChannel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lu on 16-10-8.
 */
@Configuration
public class KafkaConsumerConfiguration {
    @Value("${kafka.topic}")
    private String topic;

    @Value("${kafka.broker.address}")
    private String brokerAddress;

    @Value("${kafka.groupId}")
    private String groupId;

    @Bean
    public KafkaMessageDrivenChannelAdapter<String, String> adapter() throws Exception {
        KafkaMessageDrivenChannelAdapter<String, String> adapter = new KafkaMessageDrivenChannelAdapter<>(container());
        adapter.setOutputChannel(received());
        return adapter;
    }

    @Bean
    public KafkaMessageListenerContainer<String, String> container() throws Exception {
        return new KafkaMessageListenerContainer<String, String>(consumerFactory(),
                new ContainerProperties(new TopicPartitionInitialOffset(topic, 0)));
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<String, String>(consumerConfigs());
    }

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerAddress);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 100);
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 15000);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return props;
    }

    @Bean
    public PollableChannel received() {
        return new QueueChannel();
    }
}
