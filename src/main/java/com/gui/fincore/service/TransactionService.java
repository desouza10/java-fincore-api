package com.gui.fincore.service;

import com.gui.fincore.model.Transaction;
import com.gui.fincore.model.enums.TransactionStatus;
import com.gui.fincore.model.enums.TransactionType;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {
    public List<Transaction> findAll() {
        return List.of(
            new Transaction(
                    1L,
                    TransactionType.INCOME,
                    "Salário março",
                    new BigDecimal("8500.00"),
                    LocalDate.of(2026, 3, 5),
                    TransactionStatus.COMPLETED,
                    "Recebimento empresa",
                    100L
            ),
                new Transaction(
                        2L,
                        TransactionType.EXPENSE,
                        "Ração ds cães",
                        new BigDecimal("350.00"),
                        LocalDate.of(2026, 3, 5),
                        TransactionStatus.COMPLETED,
                        "Compra na Petz",
                        100L
                ),
                new Transaction(
                        3L,
                        TransactionType.EXPENSE,
                        "Conta de luz",
                        new BigDecimal("150.00"),
                        LocalDate.of(2026, 3, 5),
                        TransactionStatus.COMPLETED,
                        "Enel",
                        100L
                ),
                new Transaction(
                        4L,
                        TransactionType.EXPENSE,
                        "Conta de água",
                        new BigDecimal("86.78"),
                        LocalDate.of(2026, 3, 5),
                        TransactionStatus.COMPLETED,
                        "SABESP",
                        100L
                ),
                new Transaction(
                        5L,
                        TransactionType.EXPENSE,
                        "Telefonia",
                        new BigDecimal("129.99"),
                        LocalDate.of(2026, 3, 5),
                        TransactionStatus.COMPLETED,
                        "Claro Móvel",
                        100L
                )
        );
    }

    public Transaction findById(Long id) {
        return findAll().stream()
                .filter(transaction -> transaction.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Transaction not found"
                ));
    }

}
