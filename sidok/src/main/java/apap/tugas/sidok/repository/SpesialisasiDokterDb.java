package apap.tugas.sidok.repository;

import apap.tugas.sidok.model.SpesialisasiDokterModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpesialisasiDokterDb extends JpaRepository<SpesialisasiDokterModel, Long> {
    Optional<SpesialisasiDokterModel> findById(Long id);
    List<SpesialisasiDokterModel> findAll();
}
