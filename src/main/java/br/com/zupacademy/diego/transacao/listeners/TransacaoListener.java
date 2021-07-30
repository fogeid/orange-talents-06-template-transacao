package br.com.zupacademy.diego.transacao.listeners;

import br.com.zupacademy.diego.transacao.dto.TransacaoDTO;
import br.com.zupacademy.diego.transacao.models.Compra;
import br.com.zupacademy.diego.transacao.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransacaoListener {
    private CompraRepository compraRepository;

    @Autowired
    public TransacaoListener(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void consume(TransacaoDTO dto) {
        System.out.println(dto.toString());
        Compra compra = dto.toModel();
        compraRepository.save(compra);
    }
}
