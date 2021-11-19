package com.bpkadlampungtengah.realisasidanpendapatandaerah.repo;//package com.bpkadlampungtengah.realisasidanpendapatandaerah.repo;

import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.Kegiatan;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KegiatanRepo extends JpaRepository<Kegiatan, Long> {
    List<Kegiatan> findByKodeUrusanAndKodeBidangAndKodeUnitAndKodeSubUnitAndTahunIsAndKodeProgramAndIdProgram(int kodeUrusan, int kodeBidang, int kodeUnit, int kodeSubUnit, int tahun, int kodeProgram, int idProgram);
}
