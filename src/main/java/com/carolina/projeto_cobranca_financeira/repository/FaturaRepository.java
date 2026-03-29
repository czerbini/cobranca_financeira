package com.carolina.projeto_cobranca_financeira.repository;

import com.carolina.projeto_cobranca_financeira.model.Fatura;
import enums.StatusFatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Long> {
    List<Fatura> findByStatusFatura(StatusFatura status);
    List<Fatura> findByClienteCpf(String cpf);
    List<Fatura> findByDataVencimentoAndStatusFatura(LocalDate data, StatusFatura status);
}