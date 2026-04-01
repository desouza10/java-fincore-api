package com.gui.fincore.dto.transaction.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TransactionRequestDTO {
    private String type;
    private String description;
    private BigDecimal amount;
    private LocalDate date;
    private String status;
    private String notes;
    private Long userId;
}
