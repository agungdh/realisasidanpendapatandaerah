package com.bpkadlampungtengah.realisasidanpendapatandaerah.model.key.primary;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class SpmRinciId implements Serializable {
    private int tahun;
    private String noSpm;
    private int noId;
}