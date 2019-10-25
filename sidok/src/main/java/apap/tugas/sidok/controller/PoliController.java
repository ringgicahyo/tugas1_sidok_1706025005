package apap.tugas.sidok.controller;

import apap.tugas.sidok.model.PoliModel;
import apap.tugas.sidok.service.PoliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PoliController {
    @Autowired
    private PoliService poliService;

    @RequestMapping("/poli")
    public String viewAllPoli(Model model) {
        List<PoliModel> listPoli = poliService.getPoliList();
        model.addAttribute("pagetitle", "View All Poli");
        model.addAttribute("listPoli", listPoli);
        return "view-all-poli";
    }
}
