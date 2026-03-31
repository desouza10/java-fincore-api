package com.gui.fincore.model;

import com.gui.fincore.model.enums.TransactionStatus;
import com.gui.fincore.model.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private Long id;
    private TransactionType type;
    private String description;
    private BigDecimal amount;
    private LocalDate date;
    private TransactionStatus status;
    private String notes;
    private Long userId;
}
