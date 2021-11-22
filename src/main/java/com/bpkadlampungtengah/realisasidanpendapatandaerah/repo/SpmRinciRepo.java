package com.bpkadlampungtengah.realisasidanpendapatandaerah.repo;

import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.Realisasi;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.RefSubUnit;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.SpmRinci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface SpmRinciRepo extends JpaRepository<SpmRinci, Long> {
        @Query(value = "select \n" +
                "ref_rek90_6.kd_rek90_1,\n" +
                "ref_rek90_6.kd_rek90_2,\n" +
                "ref_rek90_6.kd_rek90_3,\n" +
                "ref_rek90_6.kd_rek90_4,\n" +
                "ref_rek90_6.kd_rek90_5,\n" +
                "ref_rek90_6.kd_rek90_6,\n" +
                "max(ref_rek90_6.nm_rek90_6) as nm_rek90_6,\n" +
                "max(ta_spm_rinc.kd_rek_1) as kd_rek_1,\n" +
                "max(ta_spm_rinc.kd_rek_2) as kd_rek_2,\n" +
                "max(ta_spm_rinc.kd_rek_3) as kd_rek_3,\n" +
                "max(ta_spm_rinc.kd_rek_4) as kd_rek_4,\n" +
                "max(ta_spm_rinc.kd_rek_5) as kd_rek_5,\n" +
                "max(ref_rek_5.nm_rek_5) as nm_rek_5,\n" +
                "(\n" +
                "select sum(total) as total\n" +
                "from ta_belanja_rinc_sub as __tbrs\n" +
                "where __tbrs.tahun = ta_kegiatan.tahun\n" +
                "and __tbrs.kd_urusan = ta_kegiatan.kd_urusan\n" +
                "and __tbrs.kd_bidang = ta_kegiatan.kd_bidang\n" +
                "and __tbrs.kd_unit = ta_kegiatan.kd_unit\n" +
                "and __tbrs.kd_sub = ta_kegiatan.kd_sub\n" +
                "and __tbrs.kd_prog = ta_kegiatan.kd_prog\n" +
                "and __tbrs.id_prog = ta_kegiatan.id_prog\n" +
                "and __tbrs.kd_keg = ta_kegiatan.kd_keg\n" +
                "and __tbrs.kd_rek_1 = max(ta_spm_rinc.kd_rek_1)\n" +
                "and __tbrs.kd_rek_2 = max(ta_spm_rinc.kd_rek_2)\n" +
                "and __tbrs.kd_rek_3 = max(ta_spm_rinc.kd_rek_3)\n" +
                "and __tbrs.kd_rek_4 = max(ta_spm_rinc.kd_rek_4)\n" +
                "and __tbrs.kd_rek_5 = max(ta_spm_rinc.kd_rek_5)\n" +
                ") as anggaran,\n" +
                "sum(ta_spm_rinc.nilai) as realisasi\n" +
                "from ta_spm_rinc\n" +
                "join ta_spm\n" +
                "on ta_spm.tahun = ta_spm_rinc.tahun\n" +
                "join ta_spp\n" +
                "on ta_spp.tahun = ta_spm.tahun \n" +
                "and ta_spp.no_spp = ta_spm.no_spp \n" +
                "join ref_jenis_spm\n" +
                "on ref_jenis_spm.jn_spm = ta_spm.jn_spm\n" +
                "and ta_spm.no_spm = ta_spm_rinc.no_spm\n" +
                "join ta_sp2d\n" +
                "on ta_sp2d.tahun = ta_spm.tahun \n" +
                "and ta_sp2d.no_spm = ta_spm.no_spm\n" +
                "join ref_rek_5\n" +
                "on ref_rek_5.kd_rek_1 = ta_spm_rinc.kd_rek_1\n" +
                "and ref_rek_5.kd_rek_2 = ta_spm_rinc.kd_rek_2\n" +
                "and ref_rek_5.kd_rek_3 = ta_spm_rinc.kd_rek_3\n" +
                "and ref_rek_5.kd_rek_4 = ta_spm_rinc.kd_rek_4\n" +
                "and ref_rek_5.kd_rek_5 = ta_spm_rinc.kd_rek_5\n" +
                "join ta_kegiatan\n" +
                "on ta_kegiatan.tahun = ta_spm_rinc.tahun\n" +
                "and ta_kegiatan.kd_urusan = ta_spm_rinc.kd_urusan\n" +
                "and ta_kegiatan.kd_bidang = ta_spm_rinc.kd_bidang\n" +
                "and ta_kegiatan.kd_unit = ta_spm_rinc.kd_unit\n" +
                "and ta_kegiatan.kd_sub = ta_spm_rinc.kd_sub\n" +
                "and ta_kegiatan.kd_prog = ta_spm_rinc.kd_prog\n" +
                "and ta_kegiatan.id_prog = ta_spm_rinc.id_prog\n" +
                "and ta_kegiatan.kd_keg = ta_spm_rinc.kd_keg\n" +
                "join ta_program\n" +
                "on ta_program.tahun = ta_kegiatan.tahun\n" +
                "and ta_program.kd_urusan = ta_kegiatan.kd_urusan\n" +
                "and ta_program.kd_bidang = ta_kegiatan.kd_bidang\n" +
                "and ta_program.kd_unit = ta_kegiatan.kd_unit\n" +
                "and ta_program.kd_sub = ta_kegiatan.kd_sub\n" +
                "and ta_program.kd_prog = ta_kegiatan.kd_prog\n" +
                "and ta_program.id_prog = ta_kegiatan.id_prog\n" +
                "join ref_rek_mapping\n" +
                "on ref_rek_5.kd_rek_1 = ref_rek_mapping.kd_rek_1\n" +
                "and ref_rek_5.kd_rek_2 = ref_rek_mapping.kd_rek_2\n" +
                "and ref_rek_5.kd_rek_3 = ref_rek_mapping.kd_rek_3\n" +
                "and ref_rek_5.kd_rek_4 = ref_rek_mapping.kd_rek_4\n" +
                "and ref_rek_5.kd_rek_5 = ref_rek_mapping.kd_rek_5\n" +
                "join ref_rek90_6\n" +
                "on ref_rek_mapping.kd_rek90_1 = ref_rek90_6.kd_rek90_1\n" +
                "and ref_rek_mapping.kd_rek90_2 = ref_rek90_6.kd_rek90_2\n" +
                "and ref_rek_mapping.kd_rek90_3 = ref_rek90_6.kd_rek90_3\n" +
                "and ref_rek_mapping.kd_rek90_4 = ref_rek90_6.kd_rek90_4\n" +
                "and ref_rek_mapping.kd_rek90_5 = ref_rek90_6.kd_rek90_5\n" +
                "and ref_rek_mapping.kd_rek90_6 = ref_rek90_6.kd_rek90_6\n" +
                "join ref_sub_unit\n" +
                "on ref_sub_unit.kd_urusan = ta_spm_rinc.kd_urusan\n" +
                "and ref_sub_unit.kd_bidang = ta_spm_rinc.kd_bidang\n" +
                "and ref_sub_unit.kd_unit = ta_spm_rinc.kd_unit\n" +
                "and ref_sub_unit.kd_sub = ta_spm_rinc.kd_sub\n" +
                "join ref_unit\n" +
                "on ref_unit.kd_urusan = ta_spm_rinc.kd_urusan\n" +
                "and ref_unit.kd_bidang = ta_spm_rinc.kd_bidang\n" +
                "and ref_unit.kd_unit = ta_spm_rinc.kd_unit\n" +
                "join ref_bidang\n" +
                "on ref_bidang.kd_urusan = ta_spm_rinc.kd_urusan\n" +
                "and ref_bidang.kd_bidang = ta_spm_rinc.kd_bidang\n" +
                "join ref_urusan\n" +
                "on ref_urusan.kd_urusan = ta_spm_rinc.kd_urusan\n" +
                "join ref_bidang_mapping\n" +
                "on ref_bidang_mapping.kd_urusan = ref_bidang.kd_urusan\n" +
                "and ref_bidang_mapping.kd_bidang = ref_bidang.kd_bidang\n" +
                "join ref_kegiatan_mapping\n" +
                "on ref_kegiatan_mapping.kd_urusan = ref_bidang_mapping.kd_urusan\n" +
                "and ref_kegiatan_mapping.kd_bidang = ref_bidang_mapping.kd_bidang\n" +
                "and ref_kegiatan_mapping.kd_prog = ta_kegiatan.kd_prog\n" +
                "and ref_kegiatan_mapping.kd_keg = ta_kegiatan.kd_keg\n" +
                "where ta_spm.tahun = :tahun\n" +
                "and ta_spm.kd_urusan = :kodeUrusan\n" +
                "and ta_spm.kd_bidang = :kodeBidang\n" +
                "and ta_spm.kd_unit = :kodeUnit\n" +
                "and ta_spm.kd_sub = :kodeSubUnit\n" +
                "and ta_spm_rinc.kd_prog = :kodeProgram\n" +
                "and ta_spm_rinc.id_prog = :idProgram\n" +
                "and ta_spm_rinc.kd_keg = :kodeKegiatan\n" +
                "group by ref_rek90_6.kd_rek90_1,\n" +
                "ref_rek90_6.kd_rek90_2,\n" +
                "ref_rek90_6.kd_rek90_3,\n" +
                "ref_rek90_6.kd_rek90_4,\n" +
                "ref_rek90_6.kd_rek90_5,\n" +
                "ref_rek90_6.kd_rek90_6,\n" +
                "ta_kegiatan.tahun,\n" +
                "ta_kegiatan.kd_urusan,\n" +
                "ta_kegiatan.kd_bidang,\n" +
                "ta_kegiatan.kd_unit,\n" +
                "ta_kegiatan.kd_sub,\n" +
                "ta_kegiatan.kd_prog,\n" +
                "ta_kegiatan.id_prog,\n" +
                "ta_kegiatan.kd_keg",
            nativeQuery = true)
        List<Object[]> findSumOfNilaiSpmRinci(
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
