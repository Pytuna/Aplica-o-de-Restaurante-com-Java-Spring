package com.example.demo.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriptionTypeDto {
    private Long id;

    @NotBlank(message = "Campo não pode ser nulo ou vazio")
    @Size(min = 5, max = 30, message = "Campo deve ter tamanho entre 5 a 30 caracteres")
    private String name;
    @Max(value = 12, message = "Campo não pode ser maior que 12")
    private Long accessMonths;
    @NotNull(message = "Campo não pode ser nulo")
    private BigDecimal price;
    @NotBlank(message = "Campo não pode ser nulo ou vazio")
    @Size(min = 5, max = 15, message = "Campo deve ter tamanho entre 5 a 15 caracteres")
    private String productKey;
}
