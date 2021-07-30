package br.com.zupacademy.diego.transacao.dto;

import br.com.zupacademy.diego.transacao.models.Compra;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

public class CompraDTO {
    private String id;
    private BigDecimal valor;
    private String estabelecimento;
    private String idCartao;
    private LocalDateTime efetivadaEm;

    public CompraDTO(Compra compra) {
        this.id = compra.getId();
        this.valor = compra.getValor();
        this.estabelecimento = compra.getEstabelecimento();
        this.idCartao = compra.getIdCartao();
        this.efetivadaEm = compra.getEfetivadaEm();
    }

    public String getId() {
        return id;
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

    public static Page<CompraDTO> toModel(Page<Compra> compras) {
        return compras.map(CompraDTO::new);
    }
}
