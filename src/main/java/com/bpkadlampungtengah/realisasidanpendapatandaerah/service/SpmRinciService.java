package com.bpkadlampungtengah.realisasidanpendapatandaerah.service;

import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.Kegiatan;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.SpmRinci;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.repo.KegiatanRepo;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.repo.SpmRinciRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class SpmRinciService {
    private final SpmRinciRepo spmRinciRepo;

    @Autowired
    public SpmRinciService(SpmRinciRepo spmRinciRepo) {
        this.spmRinciRepo = spmRinciRepo;
    }

    public BigDecimal findSumOfNilaiSpmRinci(
            int kodeUrusan,
            int kodeBidang,
            int kodeUnit,
            int kodeSubUnit,
            int kodeProgram,
            int idProgram,
            int kodeKegiatan
    ) {
        return spmRinciRepo.findSumOfNilaiSpmRinci(
            2021,
            kodeUrusan,
            kodeBidang,
            kodeUnit,
            kodeSubUnit,
            kodeProgram,
            idProgram,
            kodeKegiatan
        );
    }
}
