package com.bpkadlampungtengah.realisasidanpendapatandaerah.model.key.primary;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class KegiatanId implements Serializable {
    private int tahun;
    private int kodeUrusan;
    private int kodeBidang;
    private int kodeUnit;
    private int kodeSubUnit;
    private int kodeProgram;
    private int idProgram;
    private int kodeKegiatan;
}