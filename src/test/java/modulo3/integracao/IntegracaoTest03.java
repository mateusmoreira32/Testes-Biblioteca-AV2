package modulo3.integracao;

import modulo3.*;
import modulo4.Livro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class IntegracaoTest03 {

    @Test
    public void salvarLivro(){
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setNome("São Cristovão");

        Livro livro = new Livro();
        livro.setNome("Use a cabeça!: Java");
        livro.setCodigo("978-85760817");
        livro.setAutor("Bert Bates");
        livro.setValor(132.41);
        livro.setBiblioteca(biblioteca);

        boolean result = livro.salvarLivro();
        Assertions.assertTrue(result);
    }

    @Test
    public void getFaculdadeById(){
        Faculdade faculdade = Faculdade.getFaculdadeById(1);
        Assertions.assertEquals("FAFIC", faculdade.getNome());
    }

    @Test
    public void addReceitaFacul(){
        Faculdade faculdade = Mockito.mock(Faculdade.class);
        Mockito.when(faculdade.getArrecadado()).thenReturn(100.0);

        boolean pagamentoResult = Pagamento.transacao(faculdade, 100);
        Mockito.verify(faculdade, Mockito.times(1)).addReceita(100);

        Assertions.assertTrue(pagamentoResult);
    }

    @Test
    public void getFaculdades(){
        ListaFaculdade faculdades = Mockito.mock(ListaFaculdade.class);

        Faculdade faculdade = new Faculdade();
        faculdade.setNome("FAFIC");
        faculdade.setArrecadado(2000000);

        Mockito.when(faculdades.findAll()).thenReturn(Arrays.asList(faculdade));
        List<Faculdade> faculdadeList = faculdades.findAll();

        Assertions.assertEquals("FAFIC", faculdadeList.get(0).getNome());
    }

    @Test
    public void getBibliotecas(){
        ListaBiblioteca bibliotecas = Mockito.mock(ListaBiblioteca.class);

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setNome("São Cristovão");

        Mockito.when(bibliotecas.findAll()).thenReturn(Arrays.asList(biblioteca));
        List<Biblioteca> bibliotecaList = bibliotecas.findAll();

        Assertions.assertEquals("São Cristovão", bibliotecaList.get(0).getNome());
    }

}
