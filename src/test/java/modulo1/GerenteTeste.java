package modulo1;

import modulo3.Faculdade;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.logging.Logger;

public class GerenteTeste {
    private Gerente gerente;
    private final Logger logger = Logger.getLogger("my-Logger");

    @Before
    public void setUp(){
        this.gerente = new Gerente();
    }

    @After
    public void printMessage(){
        this.logger.info("Saldo atual do Gerente: " +this.gerente.getCarteira());
    }

    @Test
    public void verificaFaculdade(){
        Faculdade faculdade = new Faculdade();
        faculdade.setNome("FAFIC");

        gerente.setFaculdade(faculdade);
        Assert.assertEquals("FAFIC", gerente.getFaculdade().getNome());
    }

    @Test
    public void verificaFullService(){
        gerente.setEncarregados(List.of(new Pessoa[]{
                new Bibliotecario(),
                new Professor(),
                new Estudante(),
                new Estudante()
        }));

        gerente.addSaldoCred(200);
        gerente.addSaldoDeb(100);
        gerente.retirarSaldoCred(30);

        boolean isFull = gerente.isFull();
        Assert.assertTrue(isFull);
    }

    @Test
    public void verificaEncarregado(){
        Estudante estudante = new Estudante();
        estudante.setNome("José");

        gerente.setEncarregados(List.of(new Pessoa[]{
                new Bibliotecario(),
                new Professor(),
                estudante,
                new Estudante()
        }));

        Assert.assertEquals("José", gerente.getEncarregados().get(2).getNome());
    }

}
