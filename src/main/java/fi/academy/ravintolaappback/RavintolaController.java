package fi.academy.ravintolaappback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RavintolaController {

    @Autowired
    RavintolaDao ravdao;

    public RavintolaController(RavintolaDao ravdao) {this.ravdao = ravdao; }

    @GetMapping("ravintolat")
    public List<Ravintola> ravintolat() {
        return ravdao.haeKaikki();
    }
}
