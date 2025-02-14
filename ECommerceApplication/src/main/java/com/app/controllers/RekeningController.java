package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.payloads.RekeningDTO;
import com.app.services.RekeningService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RekeningController {

    @Autowired
    private RekeningService rekeningService;

    @PostMapping("/admin/rekening/create")
    public ResponseEntity<RekeningDTO> createRekening(@RequestBody RekeningDTO rekeningDTO) {
        RekeningDTO createdRekening = rekeningService.createRekening(rekeningDTO);
        return new ResponseEntity<RekeningDTO>(createdRekening, HttpStatus.CREATED);
    }

    @GetMapping("/bank/{bankId}")
    public ResponseEntity<List<RekeningDTO>> getRekeningsByBank(@PathVariable Long bankId) {
        List<RekeningDTO> rekenings = rekeningService.getRekeningsByBank(bankId);
        return new ResponseEntity<>(rekenings, HttpStatus.OK);
    }
}
