package org.example.negocios;

import org.example.services.CursoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;

class CursoNegocioMockTest {


    CursoService serviceMock;
    CursoNegocio negocio;
    List<String> cursos;

    @BeforeEach
    void setup() {
        serviceMock = mock(CursoService.class);
        negocio = new CursoNegocio(serviceMock);

        cursos = Arrays.asList(
                "Lucas Santos", "Marina Oliveira",
                "Pedro Almeida", "Isabela Pereira", "Rafael Souza",
                "Carolina Rodrigues", "André Costa", "Luiza Fernandes",
                "Guilherme Nunes", "Beatriz Gonçalves", "Matheus Vieira",
                "Julia Mendes", "Leonardo Carvalho", "Larissa Ribeiro",
                "Gabriel Torres", "Camila Cardoso", "Victor Lima",
                "Fernanda Oliveira", "João Ferreira", "Ana Silva",
                "Bruno Silva", "Carla Silva", "Daniel Silva"
        );
    }

    @Test
    void testeCursosRelacionadoParaSpringUsandoMock() {

        //Given
        when(serviceMock.listarCursos("Silva"))
                .thenReturn(cursos);

        //When
        var lisraCursos = negocio.listarCursos("Silva");

        //Then
        assertEquals(4, lisraCursos.size());

    }

    @Test
    void testeCursosRelacionadoParaSpringUsandoBDDMockito() {

        //Given
        given(serviceMock.listarCursos("Silva"))
                .willReturn(cursos);

        //When
        var lisraCursos = negocio.listarCursos("Silva");

        //Then
        assertThat(lisraCursos.size(), is(4));

    }

    @DisplayName("testando o metodo deleteCursos")
    @Test
    void testeDeleteCursosVerify() {

        //Given
        given(serviceMock.listarCursos("Silva"))
                .willReturn(cursos);

        //When
        negocio.deletarCursos("Silva");

        //Then
//        verify(serviceMock, times(2)).deletarCurso("Gabriel Torres");
//        verify(serviceMock, atLeast(1)).deletarCurso("Gabriel Torres");
//        verify(serviceMock, atLeastOnce()).deletarCurso("Gabriel Torres");
//        verify(serviceMock).deletarCurso("Isabela Pereira");
//        verify(serviceMock).deletarCurso("Fernanda Oliveira");

        then(serviceMock)
                .should()
                .deletarCurso("Gabriel Torres");
        then(serviceMock)
                .should()
                .deletarCurso("Isabela Pereira");
        then(serviceMock)
                .should(never())
                .deletarCurso("Bruno Silva");

    }

}