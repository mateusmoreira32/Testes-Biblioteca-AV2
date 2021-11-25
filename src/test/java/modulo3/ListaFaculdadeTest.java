package modulo3;


import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class ListaFaculdadeTest {

    private static ListaFaculdade lista;

    private static List<Faculdade> faculdades;

    private final static Logger logger = Logger.getLogger("my-logger");

    @BeforeClass
    public static void setUp(){
        lista = new ListaFaculdade();

        Faculdade faculdade = new Faculdade();
        Faculdade faculdade1 = new Faculdade();


        faculdade.setNome("FAFIC");
        faculdade1.setNome("UFCG");

        faculdades = new ArrayList<>();
        faculdades.add(faculdade);
        faculdades.add(faculdade1);

        lista.setFaculdades(faculdades);

        logger.info("Iniciando Testes: Lista de Faculdade");
    }

    @AfterClass
    public static void afterAll(){
        logger.info("Fim dos Testes: Lista de Faculdade");
    }

    @Test
    public void testAdd(){
        assertEquals(faculdades, lista.getFaculdades());
    }

    @Test
    public void testProcurarPorNome(){
        assertEquals("FAFIC", lista.pesquisarPorNome("FAFIC").getNome());
    }

    @Test
    public void testFiltarPorNome() {
        assertEquals(2, lista.filtarPorNome("C").size());
    }
}