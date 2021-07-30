package br.com.zupacademy.diego.transacao.repositories;

import br.com.zupacademy.diego.transacao.models.Compra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, String> {
    Page<Compra> findAllByIdCartao(String idCartao, Pageable pageable);
}
