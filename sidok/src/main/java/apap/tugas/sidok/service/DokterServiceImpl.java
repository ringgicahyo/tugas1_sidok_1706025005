package apap.tugas.sidok.service;

import apap.tugas.sidok.model.DokterModel;
import apap.tugas.sidok.model.SpesialisasiDokterModel;
import apap.tugas.sidok.model.SpesialisasiModel;
import apap.tugas.sidok.repository.DokterDb;
import apap.tugas.sidok.repository.JadwalJagaDb;
import apap.tugas.sidok.repository.SpesialisasiDokterDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.*;

@Service
@Transactional
public class DokterServiceImpl implements DokterService {
    @Autowired
    private DokterDb dokterDb;

    @Autowired
    private JadwalJagaDb jadwalJagaDb;

    @Autowired
    private SpesialisasiDokterDb spesialisasiDokterDb;

    @Override
    public void addDokter(DokterModel dokter) {
        String nip = generateNIP(dokter);
        dokter.setNip(nip);
        dokterDb.save(dokter);
    }

    @Override
    public List<DokterModel> getDokterList() {
        return dokterDb.findAll();
    }

    @Override
    public String generateNIP(DokterModel dokter) {
        String currentYear = String.valueOf(Year.now().getValue() + 5);

        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy", Locale.US);
        Date birthDate = dokter.getTanggal_lahir();
        String tanggalLahir = formatter.format(birthDate);

        String jenisKelamin = dokter.getJenis_kelamin().toString();

        String randomCapitalLetter = "";
        int firstUppercaseIndex = (int)'A';
        for (int i = 0; i < 2; i++) {
            Random r = new Random();
            int letterIndex = r.nextInt(26); // random number between 0 and 26
            char randomUppercase = (char) (firstUppercaseIndex + letterIndex);
            randomCapitalLetter += randomUppercase;
        }

        String nip = currentYear + tanggalLahir + jenisKelamin + randomCapitalLetter;

        return nip;
    }

    @Override
    public Optional<DokterModel> getDokterByNik(String nik) {
        return dokterDb.findByNik(nik);
    }

    @Override
    public DokterModel updateDokter(DokterModel dokterModel) {
        DokterModel targetDokter = dokterDb.findById(dokterModel.getId()).get();

        try {
            targetDokter.setNama(dokterModel.getNama());
            targetDokter.setTanggal_lahir(dokterModel.getTanggal_lahir());
            targetDokter.setTempat_lahir(dokterModel.getTempat_lahir());
            targetDokter.setJenis_kelamin(dokterModel.getJenis_kelamin());
            targetDokter.setNip(generateNIP(targetDokter));
            return targetDokter;
        } catch (NullPointerException nullException) {
            return null;
        }
    }

    @Override
    public Optional<DokterModel> getDokterById(Long id) {
        return dokterDb.findById(id);
    }


}
