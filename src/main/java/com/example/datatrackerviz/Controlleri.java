package com.example.datatrackerviz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Tämä luokka toimii reitittemenä http:pyynnölöille, kutsutaan service luokasta oikeat metodit.
 */

@RestController
@RequestMapping("/api")
public class Controlleri {
    // luodaan reititiys jokaiselle operaatiolle, palautetaan tehtäväServiceluokasta olevat metodit

    @Autowired
    private TehtavatService tehtavatService;

    public Controlleri(TehtavatService tehtavatService) {
        this.tehtavatService = tehtavatService;
    }

    @GetMapping("/nayta")
    public HashMap<Integer, Tehtavat> naytaTehtavat() {
        return tehtavatService.kaikkiTehtavat();
    }

    @PostMapping("/luo/{id}")
    public HashMap<Integer, Tehtavat> luoTehtava(@PathVariable int id, @RequestBody Tehtavat tehtavat) {
        return tehtavatService.uusiTehtava(id,tehtavat);
    }

    @GetMapping("/nayta/{id}")
    public HashMap<Integer, Tehtavat> haeTehtava(@PathVariable int id) {
       return tehtavatService.haeTehtava(id);
    }

    @PutMapping("/muokkaa")
    public HashMap<Integer, Tehtavat> muokkaa(@RequestBody Tehtavat muokattavaTehtava) {
        return tehtavatService.muokkaaTehtava(muokattavaTehtava);
    }


    @DeleteMapping("/poista/{id}")
    public HashMap<Integer, Tehtavat> poista(@PathVariable int id) {
        return tehtavatService.poistaTehtava(id);
    }
}



