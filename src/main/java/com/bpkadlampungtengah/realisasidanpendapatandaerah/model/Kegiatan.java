package com.bpkadlampungtengah.realisasidanpendapatandaerah.model;

import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.key.primary.KegiatanId;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.key.primary.ProgramId;
import lombok.*;
import org.hibernate.FetchMode;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name="tahun", referencedColumnName="tahun", insertable = false, updatable = false),
            @JoinColumn(name="kd_urusan", referencedColumnName="kd_urusan", insertable = false, updatable = false),
            @JoinColumn(name="kd_bidang", referencedColumnName="kd_bidang", insertable = false, updatable = false),
            @JoinColumn(name="kd_unit", referencedColumnName="kd_unit", insertable = false, updatable = false),
            @JoinColumn(name="kd_sub", referencedColumnName="kd_sub", insertable = false, updatable = false),
            @JoinColumn(name="kd_prog", referencedColumnName="kd_prog", insertable = false, updatable = false),
            @JoinColumn(name="id_prog", referencedColumnName="id_prog", insertable = false, updatable = false)
    })
    private Program program;
}
