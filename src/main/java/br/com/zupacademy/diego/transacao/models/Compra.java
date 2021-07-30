package br.com.zupacademy.diego.transacao.models;

import br.com.zupacademy.diego.transacao.dto.TransacaoDTO;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "tb_compra")
public class Compra {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String idTransacao;
    private BigDecimal valor;
    private String estabelecimento;
    private String idCartao;
    private LocalDateTime efetivadaEm;

    public Compra() {
    }

    public Compra(TransacaoDTO transacao) {
        this.idTransacao = transacao.getId();
        this.valor = transacao.getValor();
        this.estabelecimento = transacao.getEstabelecimento().get("nome");
        this.idCartao = transacao.getCartao().get("id");
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    public String getId() {
        return id;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public String getIdCartao() {
        return idCartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}