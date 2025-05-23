package com.validator;

import java.util.HashSet;
import java.util.Set;

public class Alumno {
    private Set<Materia> materiasAprobadas;
    
    public Alumno() {
        this.materiasAprobadas = new HashSet<>();
    }
    
    public void agregarMateriaAprobada(Materia materia) {
        materiasAprobadas.add(materia);
    }
    
    public boolean tieneAprobada(Materia materia) {
        return materiasAprobadas.contains(materia);
    }
}

