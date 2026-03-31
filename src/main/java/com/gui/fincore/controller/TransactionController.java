package com.gui.fincore.controller;

import com.gui.fincore.model.Transaction;
import com.gui.fincore.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> findAll() {
      return transactionService.findAll();
    }

    @GetMapping("/{id}")
    public Transaction findById(@PathVariable Long id) {
        return transactionService.findById(id);
    }
}
