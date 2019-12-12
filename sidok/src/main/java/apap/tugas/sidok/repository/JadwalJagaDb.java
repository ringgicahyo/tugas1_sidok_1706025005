package apap.tugas.sidok.repository;

import apap.tugas.sidok.model.JadwalJagaModel;
import apap.tugas.sidok.model.PoliModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JadwalJagaDb extends JpaRepository<JadwalJagaModel, Long> {
    Optional<JadwalJagaModel> findById(Long id);
    List<JadwalJagaModel> findAll();
    List<JadwalJagaModel> findByPoli(PoliModel poli);
}
