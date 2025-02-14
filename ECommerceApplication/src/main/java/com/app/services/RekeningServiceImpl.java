package com.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entites.Bank;
import com.app.entites.Rekening;
import com.app.payloads.RekeningDTO;
import com.app.repositories.BankRepo;
import com.app.repositories.RekeningRepo;
import com.app.services.RekeningService;
import com.app.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RekeningServiceImpl implements RekeningService {

    @Autowired
    private RekeningRepo rekeningRepository;

    @Autowired
    private BankRepo bankRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RekeningDTO createRekening(RekeningDTO rekeningDTO) {
        Bank bank = bankRepository.findById(rekeningDTO.getBankId())
                .orElseThrow(() -> new ResourceNotFoundException("Bank", "id", rekeningDTO.getBankId()));

        Rekening rekening = modelMapper.map(rekeningDTO, Rekening.class);
        rekening.setBank(bank);

        Rekening savedRekening = rekeningRepository.save(rekening);
        return modelMapper.map(savedRekening, RekeningDTO.class);
    }

    @Override
    public List<RekeningDTO> getRekeningsByBank(Long bankId) {
        List<Rekening> rekenings = rekeningRepository.findByBank_Id(bankId);
        return rekenings.stream()
                .map(rekening -> modelMapper.map(rekening, RekeningDTO.class))
                .collect(Collectors.toList());
    }
}
