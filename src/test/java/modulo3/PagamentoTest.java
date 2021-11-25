package modulo3;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class PagamentoTest {

    private final static Logger logger = Logger.getLogger("my-logger");

    @BeforeClass
    public static void setUp(){
        logger.info("Iniciando Testes: Pagamento");
    }

    @AfterClass
    public static void end(){
        logger.info("Fim dos Testes: Pagamento");
    }

    @Test
    public void testPagamento(){
        Faculdade faculdade = new Faculdade();
        faculdade.addReceita(10);
        assertTrue(Pagamento.transacao(faculdade, 20));
        assertEquals(30, faculdade.getArrecadado());
    }

    @Test
    public void testPagamentoNegativo(){
        Faculdade faculdade = new Faculdade();
        faculdade.addReceita(10);
        assertFalse(Pagamento.transacao(faculdade, -20));
        assertEquals(10, faculdade.getArrecadado());
    }

    @Test
    public void testPagamentoNullPointer(){
        assertThrowsExactly(NullPointerException.class, () -> Pagamento.transacao(null, 30));
    }
}