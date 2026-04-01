package com.gui.fincore.controller;

import com.gui.fincore.dto.transaction.request.TransactionRequestDTO;
import com.gui.fincore.dto.transaction.response.TransactionResponseDTO;
import com.gui.fincore.model.Transaction;
import com.gui.fincore.service.transaction.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<TransactionResponseDTO> findAll() {
      return transactionService.findAll();
    }

    @GetMapping("/{id}")
    public TransactionResponseDTO findById(@PathVariable Long id) {
        return transactionService.findById(id);
    }

    @PostMapping
    public TransactionResponseDTO create(@RequestBody TransactionRequestDTO request) {
        return transactionService.create(request);
    }
}
