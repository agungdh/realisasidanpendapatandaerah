package com.bpkadlampungtengah.realisasidanpendapatandaerah.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Realisasi {
    private BigDecimal realisasi;
    private int kd_rek90_1;
    private int kd_rek90_2;
    private int kd_rek90_3;
    private int kd_rek90_4;
    private int kd_rek90_5;
    private int kd_rek90_6;
}
