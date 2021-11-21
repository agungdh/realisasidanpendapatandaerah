package com.bpkadlampungtengah.realisasidanpendapatandaerah.resource;

import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.Kegiatan;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.repo.SpmRinciRepo;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.service.KegiatanService;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.service.SpmRinciService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/spmrinci")
public class SpmRinciResource {
    private final SpmRinciService spmRinciService;
    private final KegiatanService kegiatanService;

    public SpmRinciResource(SpmRinciService spmRinciService, KegiatanService kegiatanService) {
        this.spmRinciService = spmRinciService;
        this.kegiatanService = kegiatanService;
    }

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
        BigDecimal nilai = spmRinciService.findSumOfNilaiSpmRinci(
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

        HashMap<String, Object> hasil = new HashMap<>();

        hasil.put("nilai", nilai);
        hasil.put("kegiatan", kegiatan);

        return new ResponseEntity<>(hasil, HttpStatus.OK);
    }
}
