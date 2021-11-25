package modulo4;

import modulo3.Biblioteca;
import modulo3.ListaBiblioteca;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ListaLivrosTest {

    private static ListaLivros lista;
    private final static Logger logger = Logger.getLogger("my-logger");

    @BeforeClass
    public static void setUp(){
        Livro l = new Livro();
        l.setCodigo("123");
        l.setNome("Harry Potter");
        l.setAutor("J. K. Rowling");

        lista = new ListaLivros();
        lista.setLivros(List.of(new Livro[]{l}));

        logger.info("Iniciando Testes: Lista biblioteca");
    }

    @AfterClass
    public static void end(){
        logger.info("Fim dos Testes: Lista livros");
    }

    @Test
    public void testProcurarPorAutor(){
        assertEquals("J. K. Rowling", lista.findPorAutor("J. K. Rowling").getAutor());
    }

    @Test
    public void testProcurarPorCodigo(){
        assertEquals("123", lista.findPorCodigo("123").getCodigo());
    }

    @Test
    public void testProcurarPor(){
        assertEquals("Harry Potter", lista.findPorNome("Harry Potter").getNome());
    }
}
