package com.carolina.projeto_cobranca_financeira.dto;

import enums.StatusContrato;
import enums.StatusFatura;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class FaturaDTO {

    @NotBlank(message = "Código da fatura obrigatório")
    private String codigoFatura;

    @NotNull(message = "Status da fatura obrigatório")
    private StatusFatura statusFatura;

    @NotNull(message = "Status contrato obrigatório")
    private StatusContrato statusContrato;

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