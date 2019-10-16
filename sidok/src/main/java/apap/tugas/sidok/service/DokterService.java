package apap.tugas.sidok.service;

import apap.tugas.sidok.model.DokterModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DokterService {
    void addDokter(DokterModel dokter);
    List<DokterModel> getDokterList();

}
