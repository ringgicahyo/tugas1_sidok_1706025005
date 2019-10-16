package apap.tugas.sidok.controller;

import apap.tugas.sidok.service.DokterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dokter")
public class DokterController {
    @Autowired
    private DokterService dokterService;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("pagetitle", "Home");
        return "home";
    }
}
