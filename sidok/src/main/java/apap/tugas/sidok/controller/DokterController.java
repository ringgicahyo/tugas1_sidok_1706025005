package apap.tugas.sidok.controller;

import apap.tugas.sidok.model.DokterModel;
import apap.tugas.sidok.model.SpesialisasiDokterModel;
import apap.tugas.sidok.model.SpesialisasiModel;
import apap.tugas.sidok.service.DokterService;
import apap.tugas.sidok.service.SpesialisasiDokterService;
import apap.tugas.sidok.service.SpesialisasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DokterController {
    @Autowired
    private DokterService dokterService;

    @Autowired SpesialisasiService spesialisasiService;

    @Autowired
    SpesialisasiDokterService spesialisasiDokterService;

    @RequestMapping(value = "/dokter/tambah", method = RequestMethod.GET)
    public String addDokterFormPage(Model model) {
        DokterModel newDokter = new DokterModel();
        List<SpesialisasiModel> listSpesialisasi = spesialisasiService.getSpesialisasiList();
        model.addAttribute("pagetitle", "Form Add Dokter");
        model.addAttribute("dokter", newDokter);
        model.addAttribute("listSpesialisasi", listSpesialisasi);
        return "form-add-dokter";
    }

    @RequestMapping(value = "/dokter/tambah", method = RequestMethod.POST)
    public String addDokterFormSubmit(@ModelAttribute DokterModel dokter, Model model) {
        List<SpesialisasiDokterModel> listSpesialisasiDokter = dokter.getListSpesialisasiDokter();
        dokter.setListSpesialisasiDokter(null);
        dokterService.addDokter(dokter);
        for (SpesialisasiDokterModel spesialisasi: listSpesialisasiDokter) {
            if (spesialisasi.getSpesialisasi().getId() == 0) continue;
            SpesialisasiDokterModel spesialisasiDokterModel = new SpesialisasiDokterModel();
            spesialisasiDokterModel.setDokter(dokter);
            spesialisasiDokterModel.setSpesialisasi(spesialisasiService.getSpesialisasiById(spesialisasi.getSpesialisasi().getId()).get());
            spesialisasiDokterService.addSpesialisasiDokter(spesialisasiDokterModel);
        }

        model.addAttribute("pagetitle", "Add Dokter");
        model.addAttribute("nama", dokter.getNama());
        model.addAttribute("nip", dokter.getNip());
        return "submit-add-dokter";
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

}
