package com.bpkadlampungtengah.realisasidanpendapatandaerah.repo;//package com.bpkadlampungtengah.realisasidanpendapatandaerah.repo;

import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.Program;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.RefSubUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgramRepo extends JpaRepository<Program, Long> {
    List<Program> findByKodeUrusanAndKodeBidangAndKodeUnitAndKodeSubUnitAndTahunIs(int kodeUrusan, int kodeBidang, int kodeUnit, int kodeSubUnit, int tahun);
}
