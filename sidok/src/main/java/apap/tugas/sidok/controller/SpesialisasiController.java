package apap.tugas.sidok.controller;

import apap.tugas.sidok.service.SpesialisasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SpesialisasiController {
    @Autowired
    private SpesialisasiService spesialisasiService;
}
