package com.gui.fincore.dto.transaction.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TransactionResponseDTO {
    private Long id;
    private String type;
    private String description;
    private BigDecimal amount;
    private LocalDate date;
    private String status;
}
