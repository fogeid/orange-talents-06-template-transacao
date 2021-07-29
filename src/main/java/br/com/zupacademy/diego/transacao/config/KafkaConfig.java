package br.com.zupacademy.diego.transacao.config;

import br.com.zupacademy.diego.transacao.dto.TransacaoDTO;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {
    private final KafkaProperties kafkaProperties;

    public KafkaConfig(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    public Map<String, Object> consumerConfiguration() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, kafkaProperties.getConsumer().getKeyDeserializer());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, kafkaProperties.getConsumer().getValueDeserializer());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getConsumer().getGroupId());
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kafkaProperties.getConsumer().getAutoOffsetReset());
        return properties;
    }

    @Bean
    public ConsumerFactory<String, TransacaoDTO> transacaoConsumerFactory() {
        StringDeserializer stringDeserializer = new StringDeserializer();
        JsonDeserializer<TransacaoDTO> jsonDeserialize = new JsonDeserializer<>(TransacaoDTO.class, false);
        return new DefaultKafkaConsumerFactory<>(consumerConfiguration(), stringDeserializer, jsonDeserialize);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, TransacaoDTO> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, TransacaoDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(transacaoConsumerFactory());

        return factory;
    }
}
