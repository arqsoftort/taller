package com.taller;

import java.util.ArrayList;
import java.util.List;

public class Mecanico {
    
    private String nombre;
    private List<Auto> autosAsignados;
    
    public Mecanico() {
        this.autosAsignados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Auto> getAutosAsignados() {
        return autosAsignados;
    }

    public void addAutoAsignado(Auto autoAsignado) {
        this.autosAsignados.add(autoAsignado);
    }
    
}
