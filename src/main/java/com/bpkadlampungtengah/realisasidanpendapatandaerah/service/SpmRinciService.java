package com.bpkadlampungtengah.realisasidanpendapatandaerah.service;

import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.Kegiatan;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.Realisasi;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.model.SpmRinci;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.repo.KegiatanRepo;
import com.bpkadlampungtengah.realisasidanpendapatandaerah.repo.SpmRinciRepo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class SpmRinciService {
    private final SpmRinciRepo spmRinciRepo;

    @Autowired
    public SpmRinciService(SpmRinciRepo spmRinciRepo) {
        this.spmRinciRepo = spmRinciRepo;
    }

    public List<HashMap<String, Object>> findSumOfNilaiSpmRinci(
            int kodeUrusan,
            int kodeBidang,
            int kodeUnit,
            int kodeSubUnit,
            int kodeProgram,
            int idProgram,
            int kodeKegiatan
    ) {
        List<Object[]> results = spmRinciRepo.findSumOfNilaiSpmRinci(
            2021,
            kodeUrusan,
            kodeBidang,
            kodeUnit,
            kodeSubUnit,
            kodeProgram,
            idProgram,
            kodeKegiatan
        );

        Gson gson = new Gson();

        List<HashMap<String, Object>> listHehe = new ArrayList<>();

        for (int i = 0; i < results.size(); i++) {
            HashMap<String, Object> hasil = new HashMap<>();
            hasil.put("kodeRek90_1", results.get(i)[0]);
            hasil.put("kodeRek90_2", results.get(i)[1]);
            hasil.put("kodeRek90_3", results.get(i)[2]);
            hasil.put("kodeRek90_4", results.get(i)[3]);
            hasil.put("kodeRek90_5", results.get(i)[4]);
            hasil.put("kodeRek90_6", results.get(i)[5]);
            hasil.put("namaRek90_6", results.get(i)[6]);
            hasil.put("kodeRek_1", results.get(i)[7]);
            hasil.put("kodeRek_2", results.get(i)[8]);
            hasil.put("kodeRek_3", results.get(i)[9]);
            hasil.put("kodeRek_4", results.get(i)[10]);
            hasil.put("kodeRek_5", results.get(i)[11]);
            hasil.put("namaRek_5", results.get(i)[12]);
            hasil.put("anggaran", results.get(i)[13]);
            hasil.put("realisasi", results.get(i)[14]);

            listHehe.add(hasil);

//            System.out.println(gson.toJson(results.get(i)).toString());
//            System.out.println(results.get(i).toString());
        }

        return listHehe;
    }
}
