package com.app.entites;

import com.app.entites.Bank;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "rekening")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Rekening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=10)
    private Long nomorRekening;



    @ManyToOne
    @JoinColumn(name = "bank_id", nullable = false) // Foreign key dari Bank
    private Bank bank;
}
