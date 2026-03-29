package com.carolina.projeto_cobranca_financeira.service;

import com.carolina.projeto_cobranca_financeira.dto.FaturaDTO;
import com.carolina.projeto_cobranca_financeira.model.Cliente;
import com.carolina.projeto_cobranca_financeira.model.Fatura;
import com.carolina.projeto_cobranca_financeira.repository.ClienteRepository;
import com.carolina.projeto_cobranca_financeira.repository.FaturaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
@Transactional
@Service
@RequiredArgsConstructor
@Slf4j
public class FaturaService {

    private final FaturaRepository faturaRepository;
    private final ClienteRepository clienteRepository;

    public Fatura criar(FaturaDTO dto) {
        Cliente cliente = clienteRepository.findByCpf(dto.getCpfCliente())
                .orElseThrow( () -> new RuntimeException("Cliente não encontrado para o CPF " + dto.getCpfCliente()));

        Fatura fatura = new Fatura();
        fatura.setCodigoFatura(dto.getCodigoFatura());
        fatura.setStatusFatura(dto.getStatusFatura());
        fatura.setStatusContrato(dto.getStatusContrato());
        fatura.setCodigoBarras(dto.getCodigoBarras());
        fatura.setValor(dto.getValor());
        fatura.setDataVencimento(dto.getDataVencimento());
        fatura.setDataCriacao(LocalDateTime.now());
        fatura.setCliente(cliente);

        return faturaRepository.save(fatura);
    }
}
