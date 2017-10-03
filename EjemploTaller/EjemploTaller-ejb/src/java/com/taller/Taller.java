package com.taller;

import java.util.ArrayList;
import java.util.List;

public class Taller {
    
    private List<Auto> autos;
    private List<Mecanico> mecanicos;
    
    public Taller() {
        this.autos = new ArrayList<>();        
        this.mecanicos = new ArrayList<>();
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    public List<Mecanico> getMecanicos() {
        return mecanicos;
    }

    public void setMecanicos(List<Mecanico> mecanicos) {
        this.mecanicos = mecanicos;
    }
    
}
