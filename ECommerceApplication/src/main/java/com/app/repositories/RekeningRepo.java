package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entites.Rekening;

import java.util.List;

@Repository
public interface RekeningRepo extends JpaRepository<Rekening, Long> {
    Rekening findByBank_NamaBank(String namaBank);

    List<Rekening> findByBank_Id(Long id);
}
