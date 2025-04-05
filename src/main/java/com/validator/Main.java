package com.validator;

public class Main {
    public static void main(String[] args) {
        // Crear materias
        Materia algoritmos = new Materia("Algoritmos y Estructuras de Datos");
        Materia paradigmas = new Materia("Paradigmas de Programación");
        Materia disenioSistemas = new Materia("Diseño de Sistemas");
        
        // Configurar correlativas
        paradigmas.agregarCorrelativa(algoritmos);
        disenioSistemas.agregarCorrelativa(paradigmas);
        
        // Crear alumno
        Alumno alumno = new Alumno();
        
        // Caso 1: Inscripción a Algoritmos (sin correlativas)
        Inscripcion inscripcion1 = new Inscripcion(alumno);
        inscripcion1.agregarMateria(algoritmos);
        System.out.println("Inscripción a Algoritmos: " + (inscripcion1.aprobada() ? "Aprobada" : "Rechazada"));
        
        // Caso 2: Inscripción a Paradigmas (sin tener Algoritmos)
        Inscripcion inscripcion2 = new Inscripcion(alumno);
        inscripcion2.agregarMateria(paradigmas);
        System.out.println("Inscripción a Paradigmas (sin Algoritmos): " + (inscripcion2.aprobada() ? "Aprobada" : "Rechazada"));
        
        // Aprobar Algoritmos
        alumno.agregarMateriaAprobada(algoritmos);
        
        // Caso 3: Inscripción a Paradigmas (teniendo Algoritmos)
        Inscripcion inscripcion3 = new Inscripcion(alumno);
        inscripcion3.agregarMateria(paradigmas);
        System.out.println("Inscripción a Paradigmas (con Algoritmos): " + (inscripcion3.aprobada() ? "Aprobada" : "Rechazada"));
        
        // Caso 4: Inscripción a Diseño (sin tener Paradigmas)
        Inscripcion inscripcion4 = new Inscripcion(alumno);
        inscripcion4.agregarMateria(disenioSistemas);
        System.out.println("Inscripción a Diseño (sin Paradigmas): " + (inscripcion4.aprobada() ? "Aprobada" : "Rechazada"));
        
        // Aprobar Paradigmas
        alumno.agregarMateriaAprobada(paradigmas);
        
        // Caso 5: Inscripción a Diseño (teniendo Algoritmos y Paradigmas)
        Inscripcion inscripcion5 = new Inscripcion(alumno);
        inscripcion5.agregarMateria(disenioSistemas);
        System.out.println("Inscripción a Diseño (con Algoritmos y Paradigmas): " + (inscripcion5.aprobada() ? "Aprobada" : "Rechazada"));
    }
}

