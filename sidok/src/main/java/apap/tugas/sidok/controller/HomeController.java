package apap.tugas.sidok.controller;

import apap.tugas.sidok.model.DokterModel;
import apap.tugas.sidok.service.DokterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private DokterService dokterService;

    @RequestMapping("/")
    public String viewAllDokter(Model model) {
        List<DokterModel> listDokter = dokterService.getDokterList();
        model.addAttribute("pagetitle", "View All Dokter");
        return "view-all-dokter";
    }
}
