package com.bpkadlampungtengah.realisasidanpendapatandaerah.service;

import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.Program;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.RefSubUnit;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.repo.ProgramRepo;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.repo.RefSubUnitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProgramService {
    private final ProgramRepo programRepo;

    @Autowired
    public ProgramService(ProgramRepo programRepo) {
        this.programRepo = programRepo;
    }

    public List<Program> findByKodeUrusanAndKodeBidangAndKodeUnitAndKodeSubUnit(int kodeUrusan, int kodeBidang, int kodeUnit, int kodeSubUnit) {
        return programRepo.findByKodeUrusanAndKodeBidangAndKodeUnitAndKodeSubUnitAndTahunIs(kodeUrusan, kodeBidang, kodeUnit, kodeSubUnit, 2021);
    }
}
