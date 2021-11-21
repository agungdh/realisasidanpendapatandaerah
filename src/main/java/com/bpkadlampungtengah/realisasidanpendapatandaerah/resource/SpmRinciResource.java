package com.bpkadlampungtengah.realisasidanpendapatandaerah.resource;

import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.Kegiatan;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.Program;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.Realisasi;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.RefSubUnit;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.repo.SpmRinciRepo;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.service.KegiatanService;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.service.ProgramService;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.service.RefSubUnitService;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.service.SpmRinciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Ref;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/spmrinci")
public class SpmRinciResource {

    @Autowired
    SpmRinciService spmRinciService;

    @Autowired
    KegiatanService kegiatanService;

    @Autowired
    ProgramService programService;

    @Autowired
    RefSubUnitService refSubUnitService;

    @GetMapping("/{KodeUrusan}/{KodeBidang}/{KodeUnit}/{KodeSubUnit}/{kodeProgram}/{idProgram}/{kodeKegiatan}")
    public ResponseEntity<HashMap<String, Object>> findSumOfNilaiSpmRinci (
            @PathVariable("KodeUrusan") int KodeUrusan,
            @PathVariable("KodeBidang") int KodeBidang,
            @PathVariable("KodeUnit") int KodeUnit,
            @PathVariable("KodeSubUnit") int KodeSubUnit,
            @PathVariable("kodeProgram") int kodeProgram,
            @PathVariable("idProgram") int idProgram,
            @PathVariable("kodeKegiatan") int kodeKegiatan
    ) {
        List<HashMap<String, Object>> nilai = spmRinciService.findSumOfNilaiSpmRinci(
                KodeUrusan,
                KodeBidang,
                KodeUnit,
                KodeSubUnit,
                kodeProgram,
                idProgram,
                kodeKegiatan
        );

        Kegiatan kegiatan = kegiatanService.findByKodeUrusanAndKodeBidangAndKodeUnitAndKodeSubUnitAndTahunIsAndKodeProgramAndIdProgramAndKodeKegiatan(
            KodeUrusan,
            KodeBidang,
            KodeUnit,
            KodeSubUnit,
            kodeProgram,
            idProgram,
            kodeKegiatan
        );

//        Program program = programService.ambil1Program(
//                KodeUrusan,
//                KodeBidang,
//                KodeUnit,
//                KodeSubUnit,
//                kodeProgram,
//                idProgram
//        );
//
//        RefSubUnit refSubUnit = refSubUnitService.findByKodeUrusanAndKodeBidangAndKodeUnitAndKodeSubUnit(
//                KodeUrusan,
//                KodeBidang,
//                KodeUnit,
//                KodeSubUnit
//        );

        HashMap<String, Object> hasil = new HashMap<>();

        hasil.put("realisasi", nilai);
        hasil.put("kegiatan", kegiatan);
//        hasil.put("program", program);
//        hasil.put("sub_unit", refSubUnit);

        BigDecimal sumRealisasi = new BigDecimal(0);

        for (int i = 0; i < nilai.size(); i++) {
//            System.out.println(sumRealisasi);
            sumRealisasi = sumRealisasi.add(getBigDecimal(nilai.get(i).get("realisasi")));
//            System.out.println(nilai.get(i).get("realisasi"));
//            System.out.println(sumRealisasi);
//            sumRealisasi += nilai.get(i).get("realisasi");
        }

        hasil.put("realisasitotal", sumRealisasi);

        return new ResponseEntity<>(hasil, HttpStatus.OK);
    }

    public static BigDecimal getBigDecimal( Object value ) {
        BigDecimal ret = null;
        if( value != null ) {
            if( value instanceof BigDecimal ) {
                ret = (BigDecimal) value;
            } else if( value instanceof String ) {
                ret = new BigDecimal( (String) value );
            } else if( value instanceof BigInteger) {
                ret = new BigDecimal( (BigInteger) value );
            } else if( value instanceof Number ) {
                ret = new BigDecimal( ((Number)value).doubleValue() );
            } else {
                throw new ClassCastException("Not possible to coerce ["+value+"] from class "+value.getClass()+" into a BigDecimal.");
            }
        }
        return ret;
    }
}
