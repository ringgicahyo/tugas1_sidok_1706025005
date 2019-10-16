package apap.tugas.sidok.service;

import apap.tugas.sidok.model.DokterModel;
import apap.tugas.sidok.repository.DokterDb;
import apap.tugas.sidok.service.DokterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DokterServiceImpl implements DokterService {
    @Autowired
    private DokterDb dokterDb;

    @Override
    public void addDokter(DokterModel dokter) {
        dokterDb.save(dokter);
    }

    @Override
    public List<DokterModel> getDokterList() {
        return dokterDb.findAll();
    }

}
