//package apap.tugas.sidok.controller;
//
//import apap.tugas.sidok.model.DokterModel;
//import apap.tugas.sidok.model.JadwalJagaModel;
//import apap.tugas.sidok.model.PoliModel;
//import apap.tugas.sidok.service.DokterService;
//import apap.tugas.sidok.service.JadwalJagaService;
//import apap.tugas.sidok.service.PoliService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//public class JadwalJagaController {
//    @Autowired
//    private JadwalJagaService jadwalJagaService;
//
//    @Autowired
//    DokterService dokterService;
//
//    @Autowired
//    PoliService poliService;
//
//
//    @GetMapping(value = "jadwal/tambah/{nip}")
//    public String addJadwalJagaFormPage(@PathVariable String nip, Model model) {
//        DokterModel targetDokter = dokterService.getDokterByNip(nip).get();
//        List<PoliModel> listPoli = poliService.getPoliList();
//        JadwalJagaModel jadwalJaga = new JadwalJagaModel();
//        model.addAttribute("jadwalJaga", jadwalJaga);
//        model.addAttribute("listPoli", listPoli);
//        model.addAttribute("dokter", targetDokter);
//        model.addAttribute("pagetitle", "Form Tambah Jadwal Jaga");
//        return "form-add-jadwal-jaga";
//    }
//
//    @RequestMapping(value = "jadwal/tambah/{nip}", method = RequestMethod.POST)
//    public String addJadwalJagaSubmit(@ModelAttribute DokterModel dokter, JadwalJagaModel jadwalJaga, Model model) {
//        List<JadwalJagaModel> listJadwalJaga = dokter.getListJadwalJaga();
//        dokter.setListJadwalJaga(null);
//        jadwalJagaService.addJadwalJaga(jadwalJaga);
//        model.addAttribute("pagetitle", "Add Jadwal Jaga");
//        model.addAttribute("jadwalJaga", listJadwalJaga);
//        return "submit-add-jadwal-jaga";
//    }
////        PoliModel poli = poliService.getPoliById(id).get();
////        List<JadwalJagaModel> listJadwalJaga = dokterModel.getListJadwalJaga();
////        dokterModel.setListJadwalJaga(null);
////        DokterModel dokter = dokterService.getDokterByNip(nip).get();
//
////        for (JadwalJagaModel jadwalJaga : listJadwalJaga) {
////            if (jadwalJaga.getPoli().getId() == 0) continue;
////            JadwalJagaModel jadwalJagaModel = new JadwalJagaModel();
////            jadwalJagaModel.setDokter(dokter);
////            jadwalJagaModel.setPoli(poliService.getPoliById(jadwalJaga.getPoli().getId()).get());
////            jadwalJagaService.addJadwalJaga(jadwalJagaModel);
////            model.addAttribute("jadwalJaga", jadwalJagaModel);
////        }
////        model.addAttribute("namaPoli", poli.getNama());
////        model.addAttribute("namaDokter", dokter.getNama());
//}
