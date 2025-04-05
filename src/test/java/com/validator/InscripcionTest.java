package com.validator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InscripcionTest {
    
    private Alumno alumno;
    private Materia algoritmos;
    private Materia paradigmas;
    private Materia disenioSistemas;
    
    @Before
    public void setUp() {
        // Crear materias
        algoritmos = new Materia("Algoritmos y Estructuras de Datos");
        paradigmas = new Materia("Paradigmas de Programación");
        disenioSistemas = new Materia("Diseño de Sistemas");
        
        // Configurar correlativas
        paradigmas.agregarCorrelativa(algoritmos);
        disenioSistemas.agregarCorrelativa(paradigmas);
        
        // Crear alumno
        alumno = new Alumno();
    }
    
    @Test
    public void testInscripcionSinCorrelativasAprobadas() {
        // Inscripción a una materia sin tener las correlativas
        Inscripcion inscripcion = new Inscripcion(alumno);
        inscripcion.agregarMateria(paradigmas);
        
        // Debe ser rechazada porque no tiene aprobada Algoritmos
        assertFalse(inscripcion.aprobada());
    }
    
    @Test
    public void testInscripcionConCorrelativasAprobadas() {
        // Aprobar Algoritmos
        alumno.agregarMateriaAprobada(algoritmos);
        
        // Inscripción a Paradigmas teniendo aprobada Algoritmos
        Inscripcion inscripcion = new Inscripcion(alumno);
        inscripcion.agregarMateria(paradigmas);
        
        // Debe ser aprobada
        assertTrue(inscripcion.aprobada());
    }
    
    @Test
    public void testInscripcionMultiplesMaterias() {
        // Aprobar Algoritmos
        alumno.agregarMateriaAprobada(algoritmos);
        
        // Inscripción a Paradigmas y Diseño de Sistemas
        Inscripcion inscripcion = new Inscripcion(alumno);
        inscripcion.agregarMateria(paradigmas);
        inscripcion.agregarMateria(disenioSistemas);
        
        // Debe ser rechazada porque no tiene aprobada Paradigmas para cursar Diseño
        assertFalse(inscripcion.aprobada());
    }
    
    @Test
    public void testInscripcionCompleta() {
        // Aprobar Algoritmos y Paradigmas
        alumno.agregarMateriaAprobada(algoritmos);
        alumno.agregarMateriaAprobada(paradigmas);
        
        // Inscripción a Diseño de Sistemas
        Inscripcion inscripcion = new Inscripcion(alumno);
        inscripcion.agregarMateria(disenioSistemas);
        
        // Debe ser aprobada
        assertTrue(inscripcion.aprobada());
    }
    
    @Test
    public void testInscripcionMateriasSinCorrelativas() {
        // Inscripción a Algoritmos (no tiene correlativas)
        Inscripcion inscripcion = new Inscripcion(alumno);
        inscripcion.agregarMateria(algoritmos);
        
        // Debe ser aprobada
        assertTrue(inscripcion.aprobada());
    }
}

