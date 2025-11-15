package com.example.datatrackerviz;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
TehtavaService luokassa toiminnot, jota projektissa tarvitaan
 **/

@Service
public class TehtavatService {

    /**
     käytetään tässä hashmappia, keyvalua parilla olevaa tehtävää, saadaan avainarvoparilla id:llä haettua tehtävä nopeasti O(1) - ajassa
     **/
    private HashMap<Integer, Tehtavat> tehtavamap = new HashMap<>();

    public HashMap<Integer,Tehtavat> kaikkiTehtavat() {
        return tehtavamap;
    }

    public HashMap<Integer, Tehtavat> uusiTehtava(Integer id, Tehtavat uusi) {
        tehtavamap.put(id,uusi);
        return tehtavamap;
    }

    public HashMap<Integer, Tehtavat> haeTehtava(Integer id) {
        HashMap<Integer, Tehtavat> naytaTehtava = new HashMap<>();
        if (tehtavamap.containsKey(id)){
            naytaTehtava.put(id,tehtavamap.get(id));
        }
        return naytaTehtava;
    }


    public HashMap<Integer, Tehtavat> muokkaaTehtava(Tehtavat t) {
        if (tehtavamap.containsKey(t.getId())){
            tehtavamap.put(t.getId(),t);
        }
        return  tehtavamap;
    }

    public HashMap<Integer, Tehtavat> poistaTehtava(Integer id) {
        tehtavamap.remove(id);
        return tehtavamap;
    }
}
