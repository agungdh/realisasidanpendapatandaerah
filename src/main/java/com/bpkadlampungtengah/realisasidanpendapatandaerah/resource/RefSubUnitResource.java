package com.bpkadlampungtengah.realisasidanpendapatandaerah.resource;

import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.RefSubUnit;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.service.RefSubUnitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/refsubunit")
public class RefSubUnitResource {
    private final RefSubUnitService refSubUnitService;

    public RefSubUnitResource(RefSubUnitService refSubUnitService) {
        this.refSubUnitService = refSubUnitService;
    }

    @GetMapping("/")
    public ResponseEntity<List<RefSubUnit>> findAllRefSubUnit () {
        List<RefSubUnit> refSubUnits = refSubUnitService.findAllRefSubUnit();
        return new ResponseEntity<>(refSubUnits, HttpStatus.OK);
    }

    @GetMapping("/{KodeUrusan}/{KodeBidang}/{KodeUnit}/{KodeSubUnit}")
    public ResponseEntity<RefSubUnit> findByKodeUrusanAndKodeBidangAndKodeUnitAndKodeSubUnit (
            @PathVariable("KodeUrusan") int KodeUrusan,
            @PathVariable("KodeBidang") int KodeBidang,
            @PathVariable("KodeUnit") int KodeUnit,
            @PathVariable("KodeSubUnit") int KodeSubUnit
    ) {
        RefSubUnit refSubUnit = refSubUnitService.findByKodeUrusanAndKodeBidangAndKodeUnitAndKodeSubUnit(
                KodeUrusan,
                KodeBidang,
                KodeUnit,
                KodeSubUnit
        );

        if (refSubUnit != null) {
            return new ResponseEntity<>(refSubUnit, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
