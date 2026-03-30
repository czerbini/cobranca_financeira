package com.carolina.projeto_cobranca_financeira.model;

import com.carolina.projeto_cobranca_financeira.enums.StatusContrato;
import com.carolina.projeto_cobranca_financeira.enums.StatusFatura;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_faturas")
public class Fatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Enumerated(EnumType.STRING)
    private StatusFatura statusFatura;

    @Enumerated(EnumType.STRING)
    private StatusContrato statusContrato;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataUltimaAtualizacao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDateTime.now();
        this.statusFatura = StatusFatura.EMITIDA;
        this.statusContrato = StatusContrato.ATIVO;
    }

    @PreUpdate
    public void preUpdate() {
        this.dataUltimaAtualizacao = LocalDateTime.now();
    }
}