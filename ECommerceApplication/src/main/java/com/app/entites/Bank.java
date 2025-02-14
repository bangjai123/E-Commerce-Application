package com.app.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "bank", uniqueConstraints = @UniqueConstraint(columnNames = "namaBank"))
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nama bank tidak boleh kosong")
    @Size(min = 4, message = "Nama bank harus minimal 4 karakter")
    @Column(nullable = false, unique = true)
    private String namaBank;

}
