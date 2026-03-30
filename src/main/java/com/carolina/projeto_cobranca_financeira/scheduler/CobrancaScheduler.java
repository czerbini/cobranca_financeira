package com.carolina.projeto_cobranca_financeira.scheduler;

import com.carolina.projeto_cobranca_financeira.service.FaturaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CobrancaScheduler {

    private final FaturaService faturaService;

    // Todo dia às 9h
    @Scheduled(cron = "0 0 9 * * ?")
    public void executarCobrancaDiaria() {
        log.info("Iniciando envio de cobranças automáticas...");
        faturaService.enviarFaturasVencidas();
        faturaService.enviarLembretesVencimento();
        log.info("Cobranças enviadas com sucesso!");
    }
}
