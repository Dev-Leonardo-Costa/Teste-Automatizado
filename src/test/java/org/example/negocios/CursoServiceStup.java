package org.example.negocios;

import org.example.services.CursoService;

import java.util.Arrays;
import java.util.List;

class CursoServiceStup implements CursoService {

    @Override
    public  List<String> listarCursos(String estudante) {
        return Arrays.asList(
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

    @Override
    public void deletarCurso(String curso) {

    }
}