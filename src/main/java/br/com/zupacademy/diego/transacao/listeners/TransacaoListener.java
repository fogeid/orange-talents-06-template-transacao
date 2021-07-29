package br.com.zupacademy.diego.transacao.listeners;

import br.com.zupacademy.diego.transacao.dto.TransacaoDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransacaoListener {
    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void consume(TransacaoDTO dto) {
        System.out.println(dto.toString());
    }
}
