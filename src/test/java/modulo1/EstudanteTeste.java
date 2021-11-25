package modulo1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

public class EstudanteTeste {
    private Estudante estudante;
    private final Logger logger = Logger.getLogger("my-Logger");

    @Before
    public void setUp(){
        this.estudante = new Estudante();
    }

    @After
    public void printMessage(){
        this.logger.info("Saldo atual do Estudante: " +this.estudante.getCarteira());
    }

    @Test
    public void verificaCurso(){
        estudante.setCurso("Ciência da Computação");
        estudante.addSaldoCred(10);
        estudante.addSaldoDeb(50);

        Assert.assertEquals("Ciência da Computação", estudante.getCurso());
    }

    @Test
    public void VerificarPeriodoOK(){
        estudante.setPeriodo(7);
        boolean validaPeriodo = estudante.validarPeriodo();

        Assert.assertTrue(validaPeriodo);
    }

    @Test
    public void verificaMatricula(){
        estudante.setMatricula("20210102");

        boolean verificaMatricula = estudante.validaMatricula();
        Assert.assertTrue(verificaMatricula);
    }

}
