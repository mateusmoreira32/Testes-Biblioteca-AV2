package modulo1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.logging.Logger;

public class ProfessorTeste {
    private Professor professor;
    private final Logger logger = Logger.getLogger("my-Logger");

    @Before
    public void setUp(){
        this.professor = new Professor();
    }

    @After
    public void printMessage(){
        this.logger.info("Saldo atual do Professor: " +this.professor.getCarteira());
    }

    @Test
    public void verificaMatriculaFalse(){
        professor.setMatricula("20210101");
        professor.addSaldoCred(10);
        professor.addSaldoCred(30);

        boolean validaMatricula = professor.validaMatricula();
        Assert.assertFalse(validaMatricula);
    }

    @Test
    public void verificaCadeiraIndex(){
        professor.setCadeiras(List.of(new String[]{"Cálculo II", "Lógica de Programação"}));

        Assert.assertEquals("Lógica de Programação", professor.getCadeiras().get(1));
    }

    @Test
    public void verificaCadeiraNome(){
        professor.setCadeiras(List.of(new String[]{"Cálculo II", "Lógica de Programação"}));

        Assert.assertTrue(professor.verificaCadeiraNaLista("Cálculo II"));
    }

}
