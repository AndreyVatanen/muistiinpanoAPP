package com.example.datatrackerviz;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

public class Tehtavat {
// tiedot, setit getit yms. Tehtävän nimi, id ja boolean tehty vai ei
    @Setter
    @Getter
    private String tehtava;
    @Setter
    @Getter
    private boolean tehty;
    @Setter
    @Getter
    private int id;

    public Tehtavat(String tehtava, boolean tehty, int id) {
        this.tehtava = tehtava;
        this.tehty = tehty;
        this.id = id;
    }

}