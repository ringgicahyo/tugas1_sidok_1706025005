package apap.tugas.sidok.service;

import apap.tugas.sidok.model.SpesialisasiDokterModel;
import apap.tugas.sidok.model.SpesialisasiModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SpesialisasiDokterService {
    void addSpesialisasiDokter(SpesialisasiDokterModel spesialisasiDokter);
    List<SpesialisasiDokterModel> getSpesialisasiDokterList();
    List<SpesialisasiDokterModel> getDokterBySpesialisasi(SpesialisasiModel spesialisasi);
}
