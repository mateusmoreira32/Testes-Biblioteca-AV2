package modulo4.integracao;

import modulo1.Bibliotecario;
import modulo1.Estudante;
import modulo1.Gerente;
import modulo1.Professor;
import modulo4.ListaLivros;
import modulo4.ListaPessoas;
import modulo4.Livro;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegracaoTest04 {

    @Test
    public void getLivros(){
        Livro livro = Livro.findLivroByCodigo("978-85760817");
        Assertions.assertEquals("Use a cabeça!: Java", livro.getNome());
    }

    @Test
    public void findAllLivros(){
        List<Livro> livros =  Livro.findAll();

        livros.forEach(l -> {
            Assertions.assertTrue(l.getValor() < 150);
        });
    }

    @Test
    public void listarLivro(){
        ListaLivros listaLivros = new ListaLivros();

        Livro livro = Mockito.mock(Livro.class);
        Mockito.when(livro.getNome()).thenReturn("Livro Mockado");
        List<String> expectedNames = Arrays.asList("Use a cabeça!: Java", "Use a Cabeça! Python ― 2ª Edição", "Use a cabeça! HTML e CSS", "Livro Mockado");

        List<Livro> livros = Livro.findAll();
        livros.add(livro);
        listaLivros.setLivros(livros);

        listaLivros.getLivros().forEach(l -> {
            Assertions.assertTrue(expectedNames.contains(l.getNome()));
        });

        Mockito.verify(livro, Mockito.times(1)).getNome();
    }

    @Test
    public void listarEstudantesFromPessoas(){
        ListaPessoas listaPessoas = Mockito.mock(ListaPessoas.class);
        Mockito.when(listaPessoas.getPessoas()).thenReturn(Arrays.asList(new Estudante(),new Estudante(),new Professor(),new Professor(),new Estudante(),new Gerente(),new Estudante(),new Estudante(),new Bibliotecario()));
        List<Estudante> estudantes = new ArrayList<Estudante>();

        listaPessoas.getPessoas().forEach(p -> {
            if(p.getClass() == Estudante.class){
                estudantes.add((Estudante) p);
            }
        });

        Assertions.assertEquals(5, estudantes.size());
    }

    @Test
    public void agruparLivrosByName(){
        ListaLivros listaLivros = Mockito.mock(ListaLivros.class);
        Mockito.when(listaLivros.groupNyName("Use a cabeça!")).thenReturn(Livro.findAll());
        Assertions.assertEquals(3, listaLivros.groupNyName("Use a cabeça!").size());
        Mockito.verify(listaLivros, Mockito.atMost(3)).getLivros();
    }
}
