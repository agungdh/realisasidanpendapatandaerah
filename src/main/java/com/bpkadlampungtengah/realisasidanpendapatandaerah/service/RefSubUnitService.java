package com.bpkadlampungtengah.realisasidanpendapatandaerah.service;

import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.RefSubUnit;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.repo.RefSubUnitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RefSubUnitService {
    private final RefSubUnitRepo refSubUnitRepo;

    @Autowired
    public RefSubUnitService(RefSubUnitRepo refSubUnitRepo) {
        this.refSubUnitRepo = refSubUnitRepo;
    }

    public List<RefSubUnit> findAllRefSubUnit() {
        return refSubUnitRepo.findAll();
    }

    public RefSubUnit findByKodeUrusanAndKodeBidangAndKodeUnitAndKodeSubUnit(int kodeUrusan, int KodeBidang, int KodeUnit, int KodeSubUnit) {
        return refSubUnitRepo.findByKodeUrusanAndKodeBidangAndKodeUnitAndKodeSubUnit(kodeUrusan, KodeBidang, KodeUnit, KodeSubUnit);
    }
}
