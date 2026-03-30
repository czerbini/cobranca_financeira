package com.carolina.projeto_cobranca_financeira.service;

import com.carolina.projeto_cobranca_financeira.dto.FaturaDTO;
import com.carolina.projeto_cobranca_financeira.model.Cliente;
import com.carolina.projeto_cobranca_financeira.model.Fatura;
import com.carolina.projeto_cobranca_financeira.repository.ClienteRepository;
import com.carolina.projeto_cobranca_financeira.repository.FaturaRepository;
import enums.StatusFatura;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Transactional
@Service
@RequiredArgsConstructor
@Slf4j
public class FaturaService {

    private final FaturaRepository faturaRepository;
    private final ClienteRepository clienteRepository;
    private final EmailService emailService;

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

    public List<Fatura> buscarFaturaPorCpf(String cpf) {
        return faturaRepository.findByClienteCpf(cpf);
    }

    public void enviarSegundaVia(Long faturaId) {
        Fatura f = faturaRepository.findById(faturaId)
                .orElseThrow(() -> new RuntimeException("Fatura não encontrada"));

        String mensagem = "Olá, " + f.getCliente().getNome() + "!\n\n"
                + "Segue a segunda via da sua fatura.\n"
                + "Código: " + f.getCodigoFatura() + "\n"
                + "Valor: R$ " + f.getValor() + "\n"
                + "Vencimento: " + f.getDataVencimento() + "\n"
                + "Código de Barras: " + f.getCodigoBarras();

        emailService.enviarEmail(f.getCliente().getEmail(), "Segunda Via da Fatura", mensagem);
        log.info("Segunda via enviada para {}", f.getCliente().getEmail());
    }

    public void enviarFaturasVencidas() {
        List<Fatura> faturas = faturaRepository.findByStatusFatura(StatusFatura.EMITIDA);

        for (Fatura f : faturas) {
            if (f.getDataVencimento().isBefore(LocalDate.now())) {

                String mensagem = "Olá, " + f.getCliente().getNome() + "!\n\n"
                        + "Sua fatura está vencida.\n"
                        + "Código: " + f.getCodigoFatura() + "\n"
                        + "Valor: R$ " + f.getValor() + "\n"
                        + "Vencimento: " + f.getDataVencimento() + "\n"
                        + "Código de Barras: " + f.getCodigoBarras();

                emailService.enviarEmail(f.getCliente().getEmail(), "Fatura Vencida", mensagem);
                f.setStatusFatura(StatusFatura.VENCIDA);
                faturaRepository.save(f);
                log.info("Cobrança enviada para {}", f.getCliente().getEmail());
            }
        }
    }
}
