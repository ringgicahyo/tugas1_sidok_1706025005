package apap.tugas.sidok.service;

import apap.tugas.sidok.model.PoliModel;
import apap.tugas.sidok.repository.PoliDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PoliServiceImpl implements PoliService {
    @Autowired
    private PoliDb poliDb;

    @Override
    public void addPoli(PoliModel poli) {
        poliDb.save(poli);
    }

    @Override
    public List<PoliModel> getPoliList() {
        return poliDb.findAll();
    }

    @Override
    public PoliModel updatePoli(PoliModel poliModel) {
        PoliModel targetPoli = poliDb.findById(poliModel.getId()).get();

        try {
            targetPoli.setNama(poliModel.getNama());
            targetPoli.setLokasi(poliModel.getLokasi());
            return targetPoli;
        } catch (NullPointerException nullException) {
            return null;
        }
    }

    @Override
    public Optional<PoliModel> getPoliById(Long id) {
        return poliDb.findById(id);
    }

    @Override
    public void deletePoli(PoliModel poli) {
        PoliModel targetPoli = poliDb.findById(poli.getId()).get();
        poliDb.delete(targetPoli);
    }
}
