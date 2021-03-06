package com.bpkadlampungtengah.realisasidanpendapatandaerah.model.key.primary;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class RefSubUnitId implements Serializable {
    private int kodeUrusan;
    private int kodeBidang;
    private int kodeUnit;
    private int kodeSubUnit;
}