package apap.tugas.sidok.service;

import apap.tugas.sidok.model.DokterModel;
import org.springframework.stereotype.Service;

@Service
public interface DokterService {
    void addDokter(DokterModel dokter);
    
}
