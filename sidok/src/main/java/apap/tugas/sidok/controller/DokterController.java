package apap.tugas.sidok.controller;

import apap.tugas.sidok.model.DokterModel;
import apap.tugas.sidok.model.SpesialisasiModel;
import apap.tugas.sidok.service.DokterService;
import apap.tugas.sidok.service.SpesialisasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DokterController {
    @Autowired
    private DokterService dokterService;

    @Autowired SpesialisasiService spesialisasiService;

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
    public String addDokterSubmit(@ModelAttribute DokterModel dokter, Model model) {
        dokterService.addDokter(dokter);
        model.addAttribute("pagetitle", "Add Dokter");
        model.addAttribute("nama", dokter.getNama());
        model.addAttribute("nip", dokter.getNip());
        return "submit-add-dokter";
    }

    @RequestMapping(path = "/dokter", method = RequestMethod.GET)
    public String viewDokterByNik(
            @RequestParam(value = "nik") String nik, Model model
    ) {
        DokterModel dokter = dokterService.getDokterByNik(nik).get();
        model.addAttribute("dokter", dokter);
        model.addAttribute("pagetitle", "View Dokter");
        return "view-dokter-by-nik";
    }
}
