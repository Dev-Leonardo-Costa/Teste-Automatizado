package org.example.negocios;

import org.example.services.CursoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CursoNegocioTest {

    @Test
    void testeCursosRelacionadoParaSpringUsandoOStub(){
        //Given
        CursoService service = new CursoServiceStup();
        CursoNegocio negocio = new CursoNegocio(service);

        //When
        var lisraCursos = negocio.listarCursos("Silva");

        //Then
        assertEquals(4, lisraCursos.size());


    }

    @Test
    void testeCursosRelacionadoParaSpringUsandoOStubSejaVazio(){
        //Given
        CursoService service = new CursoServiceStup();
        CursoNegocio negocio = new CursoNegocio(service);

        //When
        var lisraCursos = negocio.listarCursos("Foor bar");

        //Then
        assertEquals(0, lisraCursos.size());

    }
}