package fi.academy.ravintolaappback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RavintolaController {

    @Autowired
    RavintolaDao ravdao;
    @Autowired
    ArvosteluDao arvdao;

    public RavintolaController(RavintolaDao ravdao, ArvosteluDao arvdao) {
        this.ravdao = ravdao;
        this.arvdao = arvdao;
    }

    @GetMapping("/ravintolat")
    public List<Ravintola> ravintolat() {
        return ravdao.haeKaikki();
    }

    @PostMapping("/ravintolat")
    public void luoRavintola(@RequestBody Ravintola r) {
        int id = ravdao.lisaa(r);
    }

    @GetMapping("/arvostelut/{id}")
    public List<Arvostelu> arvostelut(@PathVariable int id) { return arvdao.haeRavintolanArvostelut(id); }
}
