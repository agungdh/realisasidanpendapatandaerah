package com.bpkadlampungtengah.realisasidanpendapatandaerah.model;

import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.key.primary.ProgramId;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.key.primary.RefSubUnitId;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.key.primary.SpmRinciId;
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
@IdClass(SpmRinciId.class)
@Table(name = "ta_spm_rinc")
public class SpmRinci {
    @Id
    @Column(name="tahun", nullable = false, columnDefinition = "smallint")
    private int tahun;
    @Id
    @Column(name="no_spm", nullable = false, columnDefinition = "varchar(50)")
    private String noSpm;
    @Id
    @Column(name="no_id", nullable = false, columnDefinition = "smallint")
    private int noId;

    @Column(name="kd_urusan", nullable = false, columnDefinition = "TINYINT")
    private int kodeUrusan;
    @Column(name="kd_bidang", nullable = false, columnDefinition = "TINYINT")
    private int kodeBidang;
    @Column(name="kd_unit", nullable = false, columnDefinition = "TINYINT")
    private int kodeUnit;
    @Column(name="kd_sub", nullable = false, columnDefinition = "smallint")
    private int kodeSubUnit;
    @Column(name="kd_prog", nullable = false, columnDefinition = "smallint")
    private int kodeProgram;
    @Column(name="id_prog", nullable = false, columnDefinition = "smallint")
    private int idProgram;
    @Column(name="kd_keg", nullable = false, columnDefinition = "smallint")
    private int kodeKegiatan;
    @Column(name="kd_rek_1", nullable = false, columnDefinition = "tinyint")
    private int kodeRek1;
    @Column(name="kd_rek_2", nullable = false, columnDefinition = "tinyint")
    private int kodeRek2;
    @Column(name="kd_rek_3", nullable = false, columnDefinition = "tinyint")
    private int kodeRek3;
    @Column(name="kd_rek_4", nullable = false, columnDefinition = "tinyint")
    private int kodeRek4;
    @Column(name="kd_rek_5", nullable = false, columnDefinition = "smallint")
    private int kodeRek5;
    @Column(name="nilai", nullable = false, columnDefinition = "money")
    private BigDecimal nilai;
    @Column(name="kd_sumber", nullable = false, columnDefinition = "tinyint")
    private int kodeSumber;
}
