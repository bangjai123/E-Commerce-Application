package com.app.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RekeningDTO {

        private Long id;
        private String nomorRekening;
        private Long bankId;
}
