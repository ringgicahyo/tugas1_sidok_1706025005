package apap.tugas.sidok.service;

import apap.tugas.sidok.model.PoliModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PoliService {
    void addPoli(PoliModel poli);
    List<PoliModel> getPoliList();
    PoliModel updatePoli(PoliModel poliModel);
    Optional<PoliModel> getPoliById(Long id);
    void deletePoli(PoliModel poli);

}
