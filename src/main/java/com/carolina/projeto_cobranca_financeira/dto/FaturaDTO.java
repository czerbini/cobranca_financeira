package com.carolina.projeto_cobranca_financeira.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class FaturaDTO {

    @NotBlank(message = "Código da fatura obrigatório")
    private String codigoFatura;

    @NotBlank(message = "Código de barras obrigatório")
    private String codigoBarras;

    private String linkBoleto;
    private String codigoPix;

    @NotNull(message = "Valor obrigatório")
    private BigDecimal valor;

    @NotNull(message = "Data de vencimento obrigatória")
    private LocalDate dataVencimento;

    @NotNull(message = "CPF do cliente obrigatório")
    private String cpfCliente;
}