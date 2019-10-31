package apap.tugas.sidok.service;

import apap.tugas.sidok.model.JadwalJagaModel;
import apap.tugas.sidok.model.PoliModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JadwalJagaService {
    void addJadwalJaga(JadwalJagaModel jadwalJaga);
    List<JadwalJagaModel> getJadwalJagaList();
    List<JadwalJagaModel> getJadwalJagaByPoli(PoliModel poli);
}
