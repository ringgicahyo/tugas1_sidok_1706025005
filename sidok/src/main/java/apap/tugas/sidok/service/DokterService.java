package apap.tugas.sidok.service;

import apap.tugas.sidok.model.DokterModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DokterService {
    void addDokter(DokterModel dokter);
    List<DokterModel> getDokterList();
    String generateNIP(DokterModel dokter);
    Optional<DokterModel> getDokterByNik(String nik);
    DokterModel updateDokter(DokterModel dokterModel);
    Optional<DokterModel> getDokterById(Long id);
    void deleteDokter(DokterModel dokter);
    Optional<DokterModel> getDokterByNip(String nip);

}
