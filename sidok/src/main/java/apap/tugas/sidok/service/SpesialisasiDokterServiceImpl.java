package apap.tugas.sidok.service;

import apap.tugas.sidok.model.SpesialisasiDokterModel;
import apap.tugas.sidok.model.SpesialisasiModel;
import apap.tugas.sidok.repository.SpesialisasiDokterDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SpesialisasiDokterServiceImpl implements SpesialisasiDokterService {
    @Autowired
    private SpesialisasiDokterDb spesialisasiDokterDb;


    @Override
    public void addSpesialisasiDokter(SpesialisasiDokterModel spesialisasiDokter) {
        spesialisasiDokterDb.save(spesialisasiDokter);
    }

    @Override
    public List<SpesialisasiDokterModel> getSpesialisasiDokterList() {
        return spesialisasiDokterDb.findAll();
    }

    @Override
    public List<SpesialisasiDokterModel> getDokterBySpesialisasi(SpesialisasiModel spesialisasi) {
        return spesialisasiDokterDb.findBySpesialisasi(spesialisasi);
    }
}
