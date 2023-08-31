package org.example.services;

import java.util.List;

public interface CursoService {

    List<String> listarCursos(String estudante);
    void deletarCurso(String curso);

}
