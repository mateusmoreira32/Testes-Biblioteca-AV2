package modulo1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

public class PessoaTeste {
    Pessoa pessoa;
    private final Logger logger = Logger.getLogger("my-Logger");

    @After
    public void printMessage(){
        this.logger.info("Saldo atual da Pessoa: " +this.pessoa.getCarteira());
    }

    @Test
    public void verificaNome(){
        pessoa = new Estudante();
        pessoa.setNome("Paulo");

        Assert.assertEquals("Paulo", pessoa.getNome());
    }

    @Test
    public void verificaCredito(){
        pessoa = new Bibliotecario();

        pessoa.addSaldoCred(100);
        pessoa.addSaldoCred(50);
        pessoa.addSaldoDeb(150);
        pessoa.retirarSaldoDeb(90);

        Assert.assertTrue(pessoa.getSaldoCred()>=0);
    }

    @Test
    public void verificaCarteiraNegativa(){
        pessoa = new Gerente();

        pessoa.addSaldoDeb(100);
        pessoa.addSaldoCred(50);
        pessoa.retirarSaldoDeb(200);

        Assert.assertFalse(pessoa.getCarteira()>=0);
    }
}
