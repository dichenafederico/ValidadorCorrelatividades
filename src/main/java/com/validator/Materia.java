package com.validator;

import java.util.HashSet;
import java.util.Set;

public class Materia {
    private String nombre;
    private Set<Materia> correlativas;
    
    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new HashSet<>();
    }
    
    public void agregarCorrelativa(Materia materia) {
        correlativas.add(materia);
    }
    
    public boolean puedeCursar(Alumno alumno) {
        // Un alumno puede cursar una materia si tiene aprobadas todas sus correlativas
        for (Materia correlativa : correlativas) {
            if (!alumno.tieneAprobada(correlativa)) {
                return false;
            }
        }
        return true;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Materia materia = (Materia) obj;
        return nombre.equals(materia.nombre);
    }
    
    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}

