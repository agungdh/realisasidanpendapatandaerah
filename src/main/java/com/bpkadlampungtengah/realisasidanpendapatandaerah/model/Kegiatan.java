package com.bpkadlampungtengah.realisasidanpendapatandaerah.model;

import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.key.primary.KegiatanId;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.key.primary.ProgramId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@IdClass(KegiatanId.class)
@Table(name = "ta_kegiatan")
public class Kegiatan {
    @Id
    @Column(name="tahun", nullable = false, columnDefinition = "smallint")
    private int tahun;
    @Id
    @Column(name="kd_urusan", nullable = false, columnDefinition = "TINYINT")
    private int kodeUrusan;
    @Id
    @Column(name="kd_bidang", nullable = false, columnDefinition = "TINYINT")
    private int kodeBidang;
    @Id
    @Column(name="kd_unit", nullable = false, columnDefinition = "TINYINT")
    private int kodeUnit;
    @Id
    @Column(name="kd_sub", nullable = false, columnDefinition = "smallint")
    private int kodeSubUnit;
    @Id
    @Column(name="kd_prog", nullable = false, columnDefinition = "smallint")
    private int kodeProgram;
    @Id
    @Column(name="id_prog", nullable = false, columnDefinition = "smallint")
    private int idProgram;
    @Id
    @Column(name="kd_keg", nullable = false, columnDefinition = "smallint")
    private int kodeKegiatan;
    @Column(name="ket_kegiatan", nullable = false, columnDefinition = "varchar(255)")
    private String keteranganKegiatan;
    @Column(name="lokasi", columnDefinition = "varchar(800)")
    private String lokasi;
    @Column(name="kelompok_sasaran", columnDefinition = "varchar(255)")
    private String kelompokSasaran;
    @Column(name="status_kegiatan", nullable = false, columnDefinition = "varchar(1)")
    private String statusKegiatan;
    @Column(name="pagu_anggaran", columnDefinition = "money")
    private BigDecimal paguAnggaran;
    @Column(name="waktu_pelaksanaan", columnDefinition = "varchar(100)")
    private String waktuPelaksanaan;
    @Column(name="kd_sumber", columnDefinition = "tinyint")
    private String kodeSumber;
}
