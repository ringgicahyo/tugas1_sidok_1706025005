package apap.tugas.sidok.controller;

import apap.tugas.sidok.model.*;
import apap.tugas.sidok.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class DokterController {
    @Autowired
    private DokterService dokterService;

    @Autowired SpesialisasiService spesialisasiService;

    @Autowired
    SpesialisasiDokterService spesialisasiDokterService;

    @Autowired
    PoliService poliService;

    @Autowired
    JadwalJagaService jadwalJagaService;

    @RequestMapping("/")
    public String viewAllDokter(Model model) {
        List<DokterModel> listDokter = dokterService.getDokterList();
        model.addAttribute("pagetitle", "View All Dokter");
        model.addAttribute("listDokter", listDokter);
        return "view-all-dokter";
    }

    @RequestMapping(value = "/dokter/tambah", method = RequestMethod.GET)
    public String addDokterFormPage(Model model){
        DokterModel newDokter = new DokterModel();
        SpesialisasiModel newSpesialisasi = new SpesialisasiModel();
        SpesialisasiDokterModel spesialisasiDokterModel = new SpesialisasiDokterModel();

        spesialisasiDokterModel.setSpesialisasi(newSpesialisasi);

        List<SpesialisasiDokterModel> listSpesialisasiDokter = new ArrayList<>();

        newDokter.setListSpesialisasiDokter(listSpesialisasiDokter);
        newDokter.getListSpesialisasiDokter().add(spesialisasiDokterModel);

        List<SpesialisasiModel> listSpesialisasi = spesialisasiService.getSpesialisasiList();

        model.addAttribute("pagetitle", "Form Add Dokter");
        model.addAttribute("dokter", newDokter);
        model.addAttribute("listSpesialisasi", listSpesialisasi);
        return "form-add-dokter";
    }

    @RequestMapping(value = "/dokter/tambah", method = RequestMethod.POST)
    public String addDokterFormSubmit(@ModelAttribute DokterModel dokter, Model model) {
        List<SpesialisasiDokterModel> listSpesialisasiDokter = dokter.getListSpesialisasiDokter();
        DokterModel dokterModel = new DokterModel();

        dokterModel.setNama(dokter.getNama());
        dokterModel.setNik(dokter.getNik());
        dokterModel.setTanggal_lahir(dokter.getTanggal_lahir());
        dokterModel.setTempat_lahir(dokter.getTempat_lahir());
        dokterModel.setJenis_kelamin(dokter.getJenis_kelamin());
        dokterModel.setNip(dokterService.generateNIP(dokter));

        dokterService.addDokter(dokterModel);
        for (SpesialisasiDokterModel spesialisasiDokter : listSpesialisasiDokter){
            SpesialisasiDokterModel spesialisasiDokterModel = new SpesialisasiDokterModel();
            dokter = dokterService.getDokterById(dokterModel.getId()).get();

            Long idSpesialisasi = spesialisasiDokter.getSpesialisasi().getId();
            if (idSpesialisasi != 0) {
                SpesialisasiModel spesialisasi = spesialisasiService.getSpesialisasiById(idSpesialisasi);

                spesialisasiDokterModel.setDokter(dokter);
                spesialisasiDokterModel.setSpesialisasi(spesialisasi);

                spesialisasiDokterService.addSpesialisasiDokter(spesialisasiDokterModel);
            }
        }

        model.addAttribute("listSpesialisasiDokter", listSpesialisasiDokter);
        model.addAttribute("pagetitle", "Add Dokter");
        model.addAttribute("nama", dokter.getNama());
        model.addAttribute("nip", dokter.getNip());
        return "submit-add-dokter";
    }

    @RequestMapping(value="/dokter/tambah", method = RequestMethod.POST, params= {"addRow"})
    public String addRowSpesialisasi(@ModelAttribute DokterModel dokterModel, BindingResult bindingResult, Model model) {
        SpesialisasiDokterModel spesialisasiDokterModel = new SpesialisasiDokterModel();

        dokterModel.getListSpesialisasiDokter().add(spesialisasiDokterModel);

        List<SpesialisasiModel> listSpesialisasi = spesialisasiService.getSpesialisasiList();
        model.addAttribute("dokter", dokterModel);
        model.addAttribute("listSpesialisasi", listSpesialisasi);
        model.addAttribute("pagetitle", "Form Add Dokter");
        return "form-add-dokter";
    }

    @RequestMapping(path = "/dokter", method = RequestMethod.GET)
    public String viewDokterByNik(
            @RequestParam(value = "nikDokter") String nik, Model model
    ) {
        DokterModel dokter = dokterService.getDokterByNik(nik).get();
        model.addAttribute("dokter", dokter);
        model.addAttribute("pagetitle", "View Dokter");
        return "view-dokter-by-nik";
    }

    @RequestMapping(value = "dokter/update/{id}", method = RequestMethod.GET)
    public String updateDokterFormPage(@PathVariable Long id, Model model) {
        DokterModel existingDokter = dokterService.getDokterById(id).get();
        model.addAttribute("dokter", existingDokter);
        model.addAttribute("pagetitle", "Form Update Dokter");
        return "form-update-dokter";
    }

    @RequestMapping(value = "dokter/update/{id}", method = RequestMethod.POST)
    public String updateDokterFormSubmit(@PathVariable Long id, @ModelAttribute DokterModel dokter, Model model) {
        DokterModel newDokterData = dokterService.updateDokter(dokter);
        model.addAttribute("dokter", newDokterData);
        model.addAttribute("pagetitle", "Update Dokter");
        return "submit-update-dokter";
    }

    @RequestMapping(value = "dokter/delete/{id}")
    public String deleteDokter(@PathVariable(value = "id") Long id, Model model) {
        DokterModel dokter = dokterService.getDokterById(id).get();
        if (dokter == null) return "error-id-not-found";
        dokterService.deleteDokter(dokter);
        model.addAttribute("nama", dokter.getNama());
        model.addAttribute("pagetitle", "Delete Dokter");
        return "delete-dokter";
    }

    @RequestMapping(path = "/cari", method = RequestMethod.GET)
    public String searchDokterbySpesialisasiAndPoli(Model model) {
        List<SpesialisasiModel> listSpesialisasi = spesialisasiService.getSpesialisasiList();
        List<PoliModel> listPoli = poliService.getPoliList();

        model.addAttribute("listPoli", listPoli);
        model.addAttribute("listSpesialisasi", listSpesialisasi);
        model.addAttribute("pagetitle", "Search Dokter by Spesialisasi and Poli");
        return "search-dokter";
    }

    @RequestMapping(path = "/cari", params ={"idSpesialisasi","idPoli"}, method = RequestMethod.GET)
    public String getDokterBySpesialisasiAndPoli(
            @RequestParam(value = "idSpesialisasi", required = false) Long idSpesialisasi,
            @RequestParam(value = "idPoli", required = false) Long idPoli,
            Model model
    ) {
        List<SpesialisasiModel> listSpesialisasi = spesialisasiService.getSpesialisasiList();
        List<PoliModel> listPoli = poliService.getPoliList();

        List<DokterModel> listDokterByPoli = new ArrayList<>();
        List<DokterModel> listDokterBySpesialisasi = new ArrayList<>();

        if (idPoli != 0 && idSpesialisasi != 0) {
            PoliModel poli = poliService.getPoliById(idPoli).get();
            SpesialisasiModel spesialisasi = spesialisasiService.getSpesialisasiById(idSpesialisasi);

            List<JadwalJagaModel> listJadwalJaga = jadwalJagaService.getJadwalJagaList();
            List<SpesialisasiDokterModel> listSpesialisasiDokter = spesialisasiDokterService.getDokterBySpesialisasi(spesialisasi);

            for (JadwalJagaModel jadwalJaga : listJadwalJaga) {
                DokterModel dokterModel = jadwalJaga.getDokter();
                listDokterByPoli.add(dokterModel);
            }

            for (SpesialisasiDokterModel spesialisasiDokter : listSpesialisasiDokter) {
                DokterModel dokterModel = spesialisasiDokter.getDokter();
                listDokterBySpesialisasi.add(dokterModel);
            }

            listDokterByPoli.retainAll(listDokterBySpesialisasi);

            Set<DokterModel> listDokter = new HashSet<>(listDokterByPoli);
            listDokter.addAll(listDokterByPoli);


            model.addAttribute("poli", poli);
            model.addAttribute("spesial", spesialisasi);
            model.addAttribute("listDokter", listDokter);
        }

        model.addAttribute("listPoli", listPoli);
        model.addAttribute("listSpesialisasi", listSpesialisasi);
        model.addAttribute("pagetitle", "View Dokter by Spesialisasi and Poli");

        return "search-dokter";
    }

    @RequestMapping(path = "/cari", params ={"idPoli"}, method = RequestMethod.GET)
    public String getDokterTerbanyakByPoli(@RequestParam(value = "idPoli", required = false) Long idPoli, Model model) {
        List<PoliModel> listPoli = poliService.getPoliList();
        if (idPoli != 0) {
            PoliModel poli = poliService.getPoliById(idPoli).get();
            List<DokterModel> listDokterByPoli = new ArrayList<>();
            List<JadwalJagaModel> listJadwalJaga = jadwalJagaService.getJadwalJagaByPoli(poli);
            for (JadwalJagaModel jadwalJaga : listJadwalJaga) {
                DokterModel dokterModel = jadwalJaga.getDokter();
                listDokterByPoli.add(dokterModel);
            }
            Set<DokterModel> unique = new HashSet<>(listDokterByPoli);
            int temp = 0;

            for (DokterModel dokter : unique) {
                int count = Collections.frequency(listDokterByPoli, dokter);
                if (count > temp) {
                    temp = count;
                    model.addAttribute("dokter", dokter);
                }
            }
        }
        model.addAttribute("listPoli", listPoli);
        return "search-dokter";

    }

}
