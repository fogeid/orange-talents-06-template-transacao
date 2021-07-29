package br.com.zupacademy.diego.transacao.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

public class TransacaoDTO {
    private String id;
    private BigDecimal valor;
    private Map<String, String> estabelecimento;
    private Map<String, String> cartao;
    private LocalDateTime efetivadaEm;

    public void setId(String id) {
        this.id = id;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setEstabelecimento(Map<String, String> estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public void setCartao(Map<String, String> cartao) {
        this.cartao = cartao;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }

    @Override
    public String toString() {
        return "TransacaoDTO{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }
}
