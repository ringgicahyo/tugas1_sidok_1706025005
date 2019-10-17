package apap.tugas.sidok.service;

import apap.tugas.sidok.model.SpesialisasiModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SpesialisasiService {
    void addSpesialisasi(SpesialisasiModel spesialisasi);
    List<SpesialisasiModel> getSpesialisasiList();
}
