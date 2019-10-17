package apap.tugas.sidok.service;

import apap.tugas.sidok.model.SpesialisasiModel;
import apap.tugas.sidok.repository.SpesialisasiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SpesialisasiServiceImpl implements SpesialisasiService {
    @Autowired
    private SpesialisasiDb spesialisasiDb;

    @Override
    public void addSpesialisasi(SpesialisasiModel spesialisasi) {
        spesialisasiDb.save(spesialisasi);
    }

    @Override
    public List<SpesialisasiModel> getSpesialisasiList() {
        return spesialisasiDb.findAll();
    }
}
