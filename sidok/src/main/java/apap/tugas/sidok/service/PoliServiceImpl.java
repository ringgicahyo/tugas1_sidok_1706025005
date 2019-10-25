package apap.tugas.sidok.service;

import apap.tugas.sidok.model.PoliModel;
import apap.tugas.sidok.repository.PoliDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
}
