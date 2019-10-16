package apap.tugas.sidok.controller;

import apap.tugas.sidok.service.PoliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PoliController {
    @Autowired
    private PoliService poliService;
    
}
