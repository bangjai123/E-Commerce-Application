package com.app.services;

import com.app.payloads.BankDTO;

import java.util.List;

public interface BankService {
    BankDTO createBank(BankDTO bankDTO);
    List<BankDTO> getAllBanks();
}
