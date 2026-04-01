package com.gui.fincore.service.transaction;

import com.gui.fincore.dto.transaction.request.TransactionRequestDTO;
import com.gui.fincore.dto.transaction.response.TransactionResponseDTO;
import com.gui.fincore.exception.transaction.TransactionNotFoundException;
import com.gui.fincore.mapper.transaction.TransactionMapper;
import com.gui.fincore.model.Transaction;
import com.gui.fincore.model.enums.TransactionStatus;
import com.gui.fincore.model.enums.TransactionType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Service
public class TransactionService {
    public List<TransactionResponseDTO> findAll() {
        return Stream.of(
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
        ).map(TransactionMapper::toDTO).toList();
    }

    public TransactionResponseDTO findById(Long id) {
        return findAll().stream()
                .filter(transaction -> transaction.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new TransactionNotFoundException(id));
    }

    public TransactionResponseDTO create(TransactionRequestDTO request ) {
        Transaction transaction = new Transaction();

        transaction.setId(1L);
        transaction.setType(TransactionType.valueOf(request.getType().toUpperCase()));
        transaction.setDescription(request.getDescription());
        transaction.setAmount(request.getAmount());
        transaction.setDate(request.getDate());
        transaction.setStatus(TransactionStatus.valueOf(request.getStatus().toUpperCase()));
        transaction.setNotes(request.getNotes());
        transaction.setUserId(request.getUserId());

        return TransactionMapper.toDTO(transaction);
    }
}
