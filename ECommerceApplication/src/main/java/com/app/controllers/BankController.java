package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.payloads.BankDTO;
import com.app.services.BankService;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping
    public ResponseEntity<BankDTO> createBank(@RequestBody BankDTO bankDTO) {
        BankDTO createdBank = bankService.createBank(bankDTO);
        return new ResponseEntity<>(createdBank, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BankDTO>> getAllBanks() {
        List<BankDTO> banks = bankService.getAllBanks();
        return new ResponseEntity<>(banks, HttpStatus.OK);
    }
}
