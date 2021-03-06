package com.bpkadlampungtengah.realisasidanpendapatandaerah.model.key.primary;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ProgramId implements Serializable {
    private int tahun;
    private int kodeUrusan;
    private int kodeBidang;
    private int kodeUnit;
    private int kodeSubUnit;
    private int kodeProgram;
    private int idProgram;
}