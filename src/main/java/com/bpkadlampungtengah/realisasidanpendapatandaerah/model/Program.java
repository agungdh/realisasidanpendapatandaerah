package com.bpkadlampungtengah.realisasidanpendapatandaerah.model;

import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.key.primary.ProgramId;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.key.primary.RefSubUnitId;
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
@IdClass(ProgramId.class)
@Table(name = "ta_program")
public class Program {
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
    @Column(name="ket_program", nullable = false, columnDefinition = "varchar(255)")
    private String keteranganProgram;
    @Column(name="tolak_ukur", columnDefinition = "varchar(255)")
    private String tolakUkur;
    @Column(name="target_angka", columnDefinition = "money")
    private BigDecimal targetAngkat;
    @Column(name="target_uraian", columnDefinition = "varchar(255)")
    private String targetUraian;
    @Column(name="kd_urusan1", nullable = false, columnDefinition = "tinyint")
    private int kodeUrusan1;
    @Column(name="kd_bidang1", nullable = false, columnDefinition = "tinyint")
    private int kodeBidang1;
}
