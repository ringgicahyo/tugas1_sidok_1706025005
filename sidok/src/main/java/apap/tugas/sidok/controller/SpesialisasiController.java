package apap.tugas.sidok.controller;

import apap.tugas.sidok.model.DokterModel;
import apap.tugas.sidok.model.SpesialisasiDokterModel;
import apap.tugas.sidok.model.SpesialisasiModel;
import apap.tugas.sidok.service.DokterService;
import apap.tugas.sidok.service.SpesialisasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SpesialisasiController {
    @Autowired
    private SpesialisasiService spesialisasiService;

    @Autowired
    DokterService dokterService;

    @RequestMapping("/spesialisasi/jumlah-dokter")
    public String viewJumlahDokterForEverySpesialisasi(@ModelAttribute DokterModel dokter, Model model) {
        List<SpesialisasiModel> listSpesialisasi = spesialisasiService.getSpesialisasiList();
        List<SpesialisasiDokterModel> listSpesialisasiDokter = dokter.getListSpesialisasiDokter();
        model.addAttribute("listSpesialisasi", listSpesialisasi);
        model.addAttribute("listSpesialisasiDokter", listSpesialisasiDokter);
        model.addAttribute("pagetitle", "View Jumlah Dokter in Spesialisasi");
        return "view-jumlah-dokter-in-spesialisasi";
    }
}
