package modulo1.integracao;

import modulo1.*;
import modulo3.Faculdade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class IntegracaoTeste01 {

    @Test
    public void getBibliotecaFromBibliotecario(){
        Bibliotecario bibliotecario = new Bibliotecario();
        bibliotecario.setMatricula("20211104");
        Assertions.assertEquals("São Cristovão", bibliotecario.findBibliotecaById());
    }

    @Test
    public void getFuncionariosFromGerente(){
        Gerente gerente = new Gerente();
        gerente.setNome("Paulo Antônio");
        List<String> funcionarios = gerente.getFuncionarios();
        Assertions.assertLinesMatch(Arrays.asList("Pedro Thiago", "Paulo Roberto", "Ana Cristina", "Carla Santiago"), funcionarios);
    }

    @Test
    public void getEstudantesByPeriodo(){
        Estudante estudante = Mockito.mock(Estudante.class);
        Mockito.when(estudante.findByPeriodo(1)).thenReturn(Arrays.asList("Carlos Santiago", "Rodrigo Pacheco", "Antônio César"));
        Mockito.verify(estudante, Mockito.times(0)).findByPeriodo(1);
        List<String> estudantes = estudante.findByPeriodo(1);
        Assertions.assertTrue(estudantes.size()>2);
        Mockito.verify(estudante, Mockito.atLeastOnce()).findByPeriodo(1);
    }

    @Test
    public void InsertEstudantes(){
        Estudante estudante = Mockito.mock(Estudante.class);
        List<Estudante> estudantes = Arrays.asList(new Estudante(),new Estudante(),new Estudante(),new Estudante(),new Estudante());
        Mockito.when(estudante.insertEstudantes(estudantes)).thenReturn(true);
        Assertions.assertTrue(estudante.insertEstudantes(estudantes));
        Mockito.verify(estudante, Mockito.atMost(10));
    }

    @Test
    public void insertFaculdade(){
        Faculdade faculdade = Mockito.mock(Faculdade.class);
        faculdade.setNome(null);
        Mockito.when(faculdade.salvarFaculdade()).thenReturn(false);
        Assertions.assertFalse(faculdade.salvarFaculdade());
    }

}
