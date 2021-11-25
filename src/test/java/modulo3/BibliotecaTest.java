package modulo3;

import modulo4.Livro;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {

    private static Biblioteca biblioteca;
    private final static Logger logger = Logger.getLogger("my-logger");

    @BeforeClass
    public static void setUp(){
        biblioteca = new Biblioteca();

        Livro livro = new Livro();
        livro.setNome("Engenharia de software");
        livro.setCodigo("123");
        Livro livro1 = new Livro();
        livro1.setNome("Sistemas Embarcados");
        livro1.setCodigo("1234");
        Livro livro2 = new Livro();
        livro2.setCodigo("12345");
        livro2.setNome("Scrum book");

        biblioteca.setLivros(List.of(new Livro[]{livro, livro1, livro2}));
        logger.info("Iniciando Testes: Biblioteca");
    }

    @AfterClass
    public static void end(){
        logger.info("Fim dos Testes: Biblioteca");
    }

    @Test
    public void testBibliotecaPossueLivro(){
        assertTrue(biblioteca.possueLivro("Engenharia de software"));
    }

    @Test
    public void testBibliotecaPossueLivros(){
        Livro livro = new Livro();
        livro.setNome("Engenharia de software");
        livro.setCodigo("123");
        Livro livro1 = new Livro();
        livro1.setCodigo("1234");
        livro1.setNome("Sistemas Embarcados");

        assertTrue(biblioteca.possuiLivros(List.of(new Livro[]{livro, livro1})));
    }

    @Test
    public void testPrecoLivros(){
        assertEquals(2, biblioteca.precoDoParaEmprestimo(4));
    }
}
