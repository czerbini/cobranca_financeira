package com.carolina.projeto_cobranca_financeira.controller;

import com.carolina.projeto_cobranca_financeira.dto.ClienteDTO;
import com.carolina.projeto_cobranca_financeira.dto.FaturaDTO;
import com.carolina.projeto_cobranca_financeira.model.Fatura;
import com.carolina.projeto_cobranca_financeira.service.FaturaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faturas")
@RequiredArgsConstructor
public class FaturaController {

    private final FaturaService faturaService;

    @PostMapping
    public ResponseEntity<Fatura> criar(@RequestBody @Valid FaturaDTO dto) {
        return ResponseEntity.ok(faturaService.criar(dto));
    }
}
