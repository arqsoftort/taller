package com.taller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;

@Singleton
@LocalBean
public class TallerBean {
    
    private Taller taller;
    
    @PostConstruct
    private void init() {
        this.taller = new Taller();
        
        //datos de test
        Auto auto1 = new Auto();
        auto1.setMarca("Fiat");
        auto1.setModelo("Uno");
        Mecanico mecanico1 = new Mecanico();
        mecanico1.setNombre("Juan");
        auto1.setMecanico(mecanico1);
        mecanico1.addAutoAsignado(auto1);
    }
    
    public List<Auto> getAutos() {
        return this.taller.getAutos();
    }
    
    public List<Mecanico> getMecanicos() {
        return this.taller.getMecanicos();
    }
    
    public List<Mecanico> getMecanicosDisponibles() {
        List<Mecanico> disponibles = new ArrayList<>();
        for (Mecanico m : this.taller.getMecanicos()) {
            if (m.getAutosAsignados().isEmpty()) {
                disponibles.add(m);
            }
        }
        return disponibles;
    }

    public void agregarMecanico(Mecanico mecanico) {
        this.getMecanicos().add(mecanico);
    }

    public Taller getTaller() {
        return this.taller;
    }

}
