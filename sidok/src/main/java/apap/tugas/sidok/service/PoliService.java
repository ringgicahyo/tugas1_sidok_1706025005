package apap.tugas.sidok.service;

import apap.tugas.sidok.model.PoliModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PoliService {
    void addPoli(PoliModel poli);
    List<PoliModel> getPoliList();

}
