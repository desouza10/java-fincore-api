package com.gui.fincore.mapper.transaction;

import com.gui.fincore.dto.transaction.response.TransactionResponseDTO;
import com.gui.fincore.model.Transaction;

public class TransactionMapper {
        public static TransactionResponseDTO toDTO(Transaction transaction) {
            return new TransactionResponseDTO(
                    transaction.getId(),
                    transaction.getType().name(),
                    transaction.getDescription(),
                    transaction.getAmount(),
                    transaction.getDate(),
                    transaction.getStatus().name()
            );
        }
}
