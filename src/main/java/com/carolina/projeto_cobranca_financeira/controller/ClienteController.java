package com.carolina.projeto_cobranca_financeira.controller;

import com.carolina.projeto_cobranca_financeira.dto.ClienteDTO;
import com.carolina.projeto_cobranca_financeira.model.Cliente;
import com.carolina.projeto_cobranca_financeira.repository.ClienteRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody @Valid ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());
        return ResponseEntity.ok(clienteRepository.save(cliente));
    }
}
