package com.bpkadlampungtengah.realisasidanpendapatandaerah.repo;//package com.bpkadlampungtengah.realisasidanpendapatandaerah.repo;

import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.RefSubUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RefSubUnitRepo extends JpaRepository<RefSubUnit, Long> {
    RefSubUnit findByKodeUrusanAndKodeBidangAndKodeUnitAndKodeSubUnit(int kodeUrusan, int KodeBidang, int KodeUnit, int KodeSubUnit);
}
