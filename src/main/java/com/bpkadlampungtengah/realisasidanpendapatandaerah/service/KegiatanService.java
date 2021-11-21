package com.bpkadlampungtengah.realisasidanpendapatandaerah.service;

import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.Kegiatan;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.Program;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.repo.KegiatanRepo;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.repo.ProgramRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class KegiatanService {
    private final KegiatanRepo kegiatanRepo;

    @Autowired
    public KegiatanService(KegiatanRepo kegiatanRepo) {
        this.kegiatanRepo = kegiatanRepo;
    }

    public List<Kegiatan> findByKodeUrusanAndKodeBidangAndKodeUnitAndKodeSubUnitAndTahunIsAndKodeProgramAndIdProgram(int kodeUrusan, int kodeBidang, int kodeUnit, int kodeSubUnit, int kodeProgram, int idProgram) {
        return kegiatanRepo.findByKodeUrusanAndKodeBidangAndKodeUnitAndKodeSubUnitAndTahunIsAndKodeProgramAndIdProgram(kodeUrusan, kodeBidang, kodeUnit, kodeSubUnit, 2021, kodeProgram, idProgram);
    }

    public Kegiatan findByKodeUrusanAndKodeBidangAndKodeUnitAndKodeSubUnitAndTahunIsAndKodeProgramAndIdProgramAndKodeKegiatan(int kodeUrusan, int kodeBidang, int kodeUnit, int kodeSubUnit, int kodeProgram, int idProgram, int kodeKegiatan) {
        return kegiatanRepo.findByKodeUrusanAndKodeBidangAndKodeUnitAndKodeSubUnitAndTahunIsAndKodeProgramAndIdProgramAndKodeKegiatan(kodeUrusan, kodeBidang, kodeUnit, kodeSubUnit, 2021, kodeProgram, idProgram, kodeKegiatan);
    }
}
