package com.acadl.finora.transaction.controller;

import com.acadl.finora.auth.model.Credential;
import com.acadl.finora.transaction.dto.CreateTransactionRequest;
import com.acadl.finora.transaction.dto.TransactionResponse;
import com.acadl.finora.transaction.model.Transaction;
import com.acadl.finora.transaction.repository.TransactionRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionRepository transactionRepository;

    @PostMapping
    public ResponseEntity<TransactionResponse> create(
            @RequestBody @Valid CreateTransactionRequest request,
            @AuthenticationPrincipal Credential credential
    ) {
        Transaction transaction = new Transaction();
        transaction.setDescription(request.description());
        transaction.setAmount(request.amount());
        transaction.setType(request.type());
        transaction.setCategory(request.category());
        transaction.setDate(request.date());
        transaction.setUser(credential.getUser());

        Transaction saved = transactionRepository.save(transaction);

        return ResponseEntity.ok(TransactionResponse.from(saved));
    }
}