package com.validator;

import java.util.HashSet;
import java.util.Set;

public class Inscripcion {
    private Alumno alumno;
    private Set<Materia> materias;
    
    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        this.materias = new HashSet<>();
    }
    
    public void agregarMateria(Materia materia) {
        materias.add(materia);
    }
    
    public boolean aprobada() {
        // La inscripción es aprobada si el alumno puede cursar todas las materias
        for (Materia materia : materias) {
            if (!materia.puedeCursar(alumno)) {
                return false;
            }
        }
        return true;
    }
}

