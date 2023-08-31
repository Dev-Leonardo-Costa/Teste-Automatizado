package org.example.negocios;

import org.example.services.CursoService;

import java.util.ArrayList;
import java.util.List;

// vai set o metodo de teste (SUT) = System Under Test
public class CursoNegocio {

    private CursoService service;

    public CursoNegocio(CursoService service) {
        this.service = service;
    }

    public List<String> listarCursos(String estudante) {
        var lista = new ArrayList<String>();

        if ("Foor bar".equals(estudante)) {
            return lista;
        }

        var todosCursos = service.listarCursos(estudante);


        for (String curso : todosCursos) {
            if (curso.contains("Silva")) {
                lista.add(curso);
            }
        }

        return lista;
    }

    public void deletarCursos(String estudante) {

        var todosCursos = service.listarCursos(estudante);

        for (String curso : todosCursos) {
            if (!curso.contains("Silva")) {
                service.deletarCurso(curso);
            }
        }

    }

}
