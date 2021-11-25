package modulo3;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FaculdadeTest {

    private final static Logger logger = Logger.getLogger("my-logger");

    @BeforeClass
    public static void setUp(){
        logger.info("Iniciando Testes: Faculdade");
    }

    @AfterClass
    public static void end(){
        logger.info("Fim dos Testes: Faculdade");
    }

    @Test
    public void testCriacao(){
        Faculdade faculdade = new Faculdade();
        faculdade.setNome("FAFIC");
        faculdade.setArrecadado(100);
        assertEquals("FAFIC", faculdade.getNome());
        assertEquals(100, faculdade.getArrecadado());
    }

    @Test
    public void testAddFundos(){
        Faculdade faculdade = new Faculdade();
        faculdade.setNome("UFCG");
        faculdade.setArrecadado(100);
        faculdade.addReceita(300.5);
        assertEquals(400.5, faculdade.getArrecadado());
    }

    @Test
    public void testToString(){
        Faculdade faculdade = new Faculdade();
        assertEquals("Faculdade{nome='null', arrecadado=0.0, pessoas=null, bibliotecas=null}", faculdade.toString());
    }
}