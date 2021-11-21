package com.bpkadlampungtengah.realisasidanpendapatandaerah.resource;

import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.Kegiatan;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.Program;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.RefSubUnit;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.service.ProgramService;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.service.RefSubUnitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/program")
public class ProgramResource {
    private final ProgramService programService;

    public ProgramResource(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping("/{KodeUrusan}/{KodeBidang}/{KodeUnit}/{KodeSubUnit}/{kodeProgram}/{idProgram}")
    public ResponseEntity<Program> programLur (
            @PathVariable("KodeUrusan") int KodeUrusan,
            @PathVariable("KodeBidang") int KodeBidang,
            @PathVariable("KodeUnit") int KodeUnit,
            @PathVariable("KodeSubUnit") int KodeSubUnit,
            @PathVariable("kodeProgram") int kodeProgram,
            @PathVariable("idProgram") int idProgram
    ) {
        Program program = programService.ambil1Program(
                KodeUrusan,
                KodeBidang,
                KodeUnit,
                KodeSubUnit,
                kodeProgram,
                idProgram
        );

        if (program != null) {
            return new ResponseEntity<>(program, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{KodeUrusan}/{KodeBidang}/{KodeUnit}/{KodeSubUnit}")
    public ResponseEntity<List<Program>> findByKodeUrusanAndKodeBidangAndKodeUnitAndKodeSubUnit (
            @PathVariable("KodeUrusan") int KodeUrusan,
            @PathVariable("KodeBidang") int KodeBidang,
            @PathVariable("KodeUnit") int KodeUnit,
            @PathVariable("KodeSubUnit") int KodeSubUnit
    ) {
        List<Program> programs = programService.findByKodeUrusanAndKodeBidangAndKodeUnitAndKodeSubUnit(
                KodeUrusan,
                KodeBidang,
                KodeUnit,
                KodeSubUnit
        );

        return new ResponseEntity<>(programs, HttpStatus.OK);
    }
}
