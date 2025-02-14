package com.app.services;

import com.app.payloads.RekeningDTO;

import java.util.List;

public interface RekeningService {
    RekeningDTO createRekening(RekeningDTO rekeningDTO);
    List<RekeningDTO> getRekeningsByBank(Long bankId);
}
