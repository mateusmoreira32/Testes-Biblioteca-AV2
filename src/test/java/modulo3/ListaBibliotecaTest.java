package modulo3;

import modulo1.Gerente;
import modulo4.Livro;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import java.util.List;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

public class ListaBibliotecaTest {

    private static ListaBiblioteca lista;
    private final static Logger logger = Logger.getLogger("my-logger");

    @BeforeClass
    public static void setUp(){

        Livro livro = new Livro();
        livro.setNome("Engenharia de software");
        Livro livro1 = new Livro();
        livro1.setNome("Sistemas Embarcados");
        Livro livro2 = new Livro();
        livro2.setNome("Scrum book");

        Biblioteca b = new Biblioteca();
        Gerente lucas = new Gerente();
        lucas.setNome("Lucas");
        b.setGerente(lucas);
        b.setNome("b");
        b.setLivros(List.of(new Livro[]{livro, livro1, livro2}));

        Biblioteca b1 = new Biblioteca();
        b1.setLivros(List.of(new Livro[]{livro, livro1}));
        Gerente zezinho = new Gerente();
        zezinho.setNome("zezinho");
        b1.setGerente(zezinho);
        b1.setNome("b1");

        lista = new ListaBiblioteca();
        lista.setBibliotecas(List.of(new Biblioteca[]{b, b1}));
        logger.info("Iniciando Testes: Lista biblioteca");
    }

    @AfterClass
    public static void end(){
        logger.info("Fim dos Testes: Lista biblioteca");
    }

    @Test
    public void testProcurarPorQuantLivros(){
        assertEquals(1, lista.findPorQuantLivros(3).size());
    }

    @Test
    public void testProcurarPorGerente(){
        assertNotNull(lista.findPorGerente("Lucas"));
    }

    @Test
    public void testProcurarPorNome(){
        assertEquals("Lucas", lista.findPorNome("b").getGerente().getNome());
    }
}
