package com.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entites.Bank;
import com.app.payloads.BankDTO;
import com.app.repositories.BankRepo;
import com.app.services.BankService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepo bankRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BankDTO createBank(BankDTO bankDTO) {
        Bank bank = modelMapper.map(bankDTO, Bank.class);
        Bank savedBank = bankRepository.save(bank);
        return modelMapper.map(savedBank, BankDTO.class);
    }

    @Override
    public List<BankDTO> getAllBanks() {
        List<Bank> banks = bankRepository.findAll();
        return banks.stream()
                .map(bank -> modelMapper.map(bank, BankDTO.class))
                .collect(Collectors.toList());
    }
}
