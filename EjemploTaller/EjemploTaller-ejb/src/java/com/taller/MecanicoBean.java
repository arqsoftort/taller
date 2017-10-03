package com.taller;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class MecanicoBean {
    
    @EJB
    private TallerBean tallerBean;
    
    public Mecanico crearMecanico(String nombre) throws Exception {
        
        if (nombre == null || nombre.length() < 3) {
            throw new InvalidDataException("nombre", "Debe ser mayor a 3 caracteres");
        }
        
        Mecanico mecanico = new Mecanico();
        mecanico.setNombre(nombre);
        tallerBean.agregarMecanico(mecanico);
        return mecanico;
    }
    
    public void asignarAuto(Mecanico mecanico, Auto auto) {
        mecanico.addAutoAsignado(auto);
    }

}
