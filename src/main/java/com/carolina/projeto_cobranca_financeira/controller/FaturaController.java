package com.carolina.projeto_cobranca_financeira.controller;

import com.carolina.projeto_cobranca_financeira.dto.ClienteDTO;
import com.carolina.projeto_cobranca_financeira.dto.FaturaDTO;
import com.carolina.projeto_cobranca_financeira.model.Fatura;
import com.carolina.projeto_cobranca_financeira.service.FaturaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faturas")
@RequiredArgsConstructor
public class FaturaController {

    private final FaturaService faturaService;

    @PostMapping
    public ResponseEntity<Fatura> criar(@RequestBody @Valid FaturaDTO dto) {
        return ResponseEntity.ok(faturaService.criar(dto));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<List<Fatura>> buscarPorCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(faturaService.buscarFaturaPorCpf(cpf));
    }

    @PostMapping("/{id}/segunda-via")
    public ResponseEntity<String> segundaVia(@PathVariable Long id) {
        faturaService.enviarSegundaVia(id);
        return ResponseEntity.ok("Segunda via enviada com sucesso!");
    }

    @PostMapping("/enviar-vencidas")
    public ResponseEntity<String> enviarVencidas() {
        faturaService.enviarFaturasVencidas();
        return ResponseEntity.ok("Cobranças enviadas!");
    }

    @PostMapping("/enviar-lembretes")
    public ResponseEntity<String> enviarLembretes() {
        faturaService.enviarLembretesVencimento();
        return ResponseEntity.ok("Lembretes enviados!");
    }
}
