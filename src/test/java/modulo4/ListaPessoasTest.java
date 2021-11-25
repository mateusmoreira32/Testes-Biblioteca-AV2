package modulo4;

import junit.framework.Assert;
import modulo1.Pessoa;
import org.junit.After;
import org.junit.Test;


import java.util.logging.Logger;

public class ListaPessoasTest {

    private static ListaPessoas lista;
    private final static Logger logger = Logger.getLogger("my-logger");

    @After
    public void printMessage(){
        this.logger.info("Inicio dos testes" );
    }

    @Test
    public void testProcurarPorNome(){
        Pessoa pessoa = new Pessoa() {};
        pessoa.setNome("Higor");

        Assert.assertEquals("Higor", pessoa.getNome());
    }

    @Test
    public void testProcurarPorIdade(){
        Pessoa pessoa = new Pessoa(){};
        pessoa.setIdade(24);

        Assert.assertEquals(24, pessoa.getIdade());
    }

    @Test
    public void testProcurarPorSaldo(){
        Pessoa pessoa = new Pessoa() {};
        pessoa.addSaldoCred(50.0);

        Assert.assertEquals(50.0, pessoa.getSaldoCred());
    }
}
