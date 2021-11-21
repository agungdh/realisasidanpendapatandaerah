package com.bpkadlampungtengah.realisasidanpendapatandaerah.model;

import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.key.primary.RefSubUnitId;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(RefSubUnitId.class)
@Table(name = "ref_sub_unit")
public class RefSubUnit {
    @Id
    @Column(name="kd_urusan", nullable = false, columnDefinition = "TINYINT(1)")
    private int kodeUrusan;
    @Id
    @Column(name="kd_bidang", nullable = false, columnDefinition = "TINYINT(1)")
    private int kodeBidang;
    @Id
    @Column(name="kd_unit", nullable = false, columnDefinition = "TINYINT(1)")
    private int kodeUnit;
    @Id
    @Column(name="kd_sub", nullable = false, columnDefinition = "smallint")
    private int kodeSubUnit;
    @Column(name="nm_sub_unit", nullable = false, columnDefinition = "varchar(255)")
    private String namaSubUnit;
}
