package apap.tugas.sidok.controller;

import apap.tugas.sidok.model.DokterModel;
import apap.tugas.sidok.model.JadwalJagaModel;
import apap.tugas.sidok.model.PoliModel;
import apap.tugas.sidok.service.DokterService;
import apap.tugas.sidok.service.JadwalJagaService;
import apap.tugas.sidok.service.PoliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class PoliController {
    @Autowired
    private PoliService poliService;

    @Autowired
    JadwalJagaService jadwalJagaService;

    @Autowired
    DokterService dokterService;

    @RequestMapping("/poli")
    public String viewAllPoli(Model model) {
        List<PoliModel> listPoli = poliService.getPoliList();
        model.addAttribute("pagetitle", "View All Poli");
        model.addAttribute("listPoli", listPoli);
        return "view-all-poli";
    }

    @RequestMapping(value = "/poli/tambah", method = RequestMethod.GET)
    public String addPoliFormPage(Model model) {
        PoliModel newPoli = new PoliModel();
        model.addAttribute("pagetitle", "Form Add Poli");
        model.addAttribute("poli", newPoli);
        return "form-add-poli";
    }

    @RequestMapping(value = "/poli/tambah", method = RequestMethod.POST)
    public String addPoliSubmit(@ModelAttribute PoliModel poli, Model model) {
        poliService.addPoli(poli);
        model.addAttribute("pagetitle", "Add Poli");
        model.addAttribute("namaPoli", poli.getNama());
        return "submit-add-poli";
    }

    @RequestMapping(path = "/poli/view/{id}", method = RequestMethod.GET)
    public String viewPoliById(@PathVariable Long id, Model model
    ) {
        PoliModel poli = poliService.getPoliById(id).get();
        model.addAttribute("poli", poli);
        model.addAttribute("pagetitle", "View Poli");
        return "view-poli-by-id";
    }

    @RequestMapping(value = "poli/update/{id}", method = RequestMethod.GET)
    public String updatePoliFormPage(@PathVariable Long id, Model model) {
        PoliModel existingPoli = poliService.getPoliById(id).get();
        model.addAttribute("poli", existingPoli);
        model.addAttribute("pagetitle", "Form Update Poli");
        return "form-update-poli";
    }

    @RequestMapping(value = "poli/update/{id}", method = RequestMethod.POST)
    public String updatePoliFormSubmit(@PathVariable Long id, @ModelAttribute PoliModel poli, Model model) {
        PoliModel newPoliData = poliService.updatePoli(poli);
        model.addAttribute("poli", newPoliData);
        model.addAttribute("pagetitle", "Update Poli");
        return "submit-update-poli";
    }

    @RequestMapping(value = "poli/delete/{id}")
    public String deletePoli(@PathVariable(value = "id") Long id, Model model) {
        PoliModel poli = poliService.getPoliById(id).get();
        if (poli == null) return "error-id-not-found";
        poliService.deletePoli(poli);
        model.addAttribute("nama", poli.getNama());
        model.addAttribute("pagetitle", "Delete Poli");
        return "delete-poli";
    }

    @RequestMapping(path = "/poli/dokter/{id}", method = RequestMethod.GET)
    public String viewListDokterByIdPoli(@PathVariable Long id, Model model) {
        List<JadwalJagaModel> listJadwalJaga = jadwalJagaService.getJadwalJagaList();
        PoliModel poli = poliService.getPoliById(id).get();
        List<DokterModel> listDokterByPoli = new ArrayList<>();
        List<JadwalJagaModel> listJadwalJagaByPoli = jadwalJagaService.getJadwalJagaByPoli(poli);
        for (JadwalJagaModel jadwalJaga : listJadwalJagaByPoli){
            DokterModel dokterModel = jadwalJaga.getDokter();
            listDokterByPoli.add(dokterModel);
        }
        Set<DokterModel> unique = new HashSet<>(listDokterByPoli);
        unique.addAll(listDokterByPoli);

        model.addAttribute("unique", unique);
        model.addAttribute("listJadwalJaga", listJadwalJaga);
        model.addAttribute("poli", poli);
        model.addAttribute("pagetitle", "View List Dokter by Poli");
        return "view-list-dokter-by-id-poli";
    }
}
