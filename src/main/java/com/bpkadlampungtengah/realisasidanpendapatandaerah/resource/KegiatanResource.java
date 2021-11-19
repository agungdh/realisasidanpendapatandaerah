package com.bpkadlampungtengah.realisasidanpendapatandaerah.resource;

import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.Kegiatan;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.Program;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.service.KegiatanService;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.service.ProgramService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/kegiatan")
public class KegiatanResource {
    private final KegiatanService kegiatanService;

    public KegiatanResource(KegiatanService kegiatanService) {
        this.kegiatanService = kegiatanService;
    }

    @GetMapping("/{KodeUrusan}/{KodeBidang}/{KodeUnit}/{KodeSubUnit}/{kodeProgram}/{idProgram}")
    public ResponseEntity<List<Kegiatan>> findByKodeUrusanAndKodeBidangAndKodeUnitAndKodeSubUnit (
            @PathVariable("KodeUrusan") int KodeUrusan,
            @PathVariable("KodeBidang") int KodeBidang,
            @PathVariable("KodeUnit") int KodeUnit,
            @PathVariable("KodeSubUnit") int KodeSubUnit,
            @PathVariable("kodeProgram") int kodeProgram,
            @PathVariable("idProgram") int idProgram
    ) {
        List<Kegiatan> kegiatans = kegiatanService.findByKodeUrusanAndKodeBidangAndKodeUnitAndKodeSubUnit(
                KodeUrusan,
                KodeBidang,
                KodeUnit,
                KodeSubUnit,
                kodeProgram,
                idProgram
        );

        return new ResponseEntity<>(kegiatans, HttpStatus.OK);
    }
}
