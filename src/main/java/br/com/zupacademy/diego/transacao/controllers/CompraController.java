package br.com.zupacademy.diego.transacao.controllers;

import br.com.zupacademy.diego.transacao.dto.CompraDTO;
import br.com.zupacademy.diego.transacao.models.Compra;
import br.com.zupacademy.diego.transacao.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/compras")
public class CompraController {
    private CompraRepository compraRepository;

    @Autowired
    public CompraController(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @GetMapping("/{idCartao}")
    @Transactional
    public ResponseEntity<Page<CompraDTO>> getTransacoes(@PathVariable String idCartao,
                 @PageableDefault(sort = "efetivadaEm", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Compra> compras = compraRepository.findAllByIdCartao(idCartao, pageable);
        if (compras.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(CompraDTO.toModel(compras));
    }
}
