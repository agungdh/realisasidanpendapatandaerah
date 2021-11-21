package com.bpkadlampungtengah.realisasidanpendapatandaerah.repo;

import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.RefSubUnit;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.SpmRinci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface SpmRinciRepo extends JpaRepository<SpmRinci, Long> {
        @Query(value = "" +
            "SELECT SUM(nilai) AS nilai " +
            "FROM ta_spm_rinc " +
            "WHERE tahun = :tahun" +
            " AND kd_urusan = :kodeUrusan" +
            " AND kd_bidang = :kodeBidang" +
            " AND kd_unit = :kodeUnit" +
            " AND kd_sub = :kodeSubUnit" +
            " AND kd_prog = :kodeProgram" +
            " AND id_prog = :idProgram" +
            " AND kd_keg = :kodeKegiatan",
            nativeQuery = true)
        BigDecimal findSumOfNilaiSpmRinci(
            @Param("tahun") int tahun,
            @Param("kodeUrusan") int kodeUrusan,
            @Param("kodeBidang") int kodeBidang,
            @Param("kodeUnit") int kodeUnit,
            @Param("kodeSubUnit") int kodeSubUnit,
            @Param("kodeProgram") int kodeProgram,
            @Param("idProgram") int idProgram,
            @Param("kodeKegiatan") int kodeKegiatan
        );
}
