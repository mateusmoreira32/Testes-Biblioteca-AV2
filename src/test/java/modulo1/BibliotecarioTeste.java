package modulo1;

import modulo3.Faculdade;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.logging.Logger;

public class BibliotecarioTeste {
    private Bibliotecario bibliotecario;
    private final Logger logger = Logger.getLogger("my-Logger");

    @Before
    public void setUp(){
        this.bibliotecario = new Bibliotecario();
    }

    @After
    public void printMessage(){
        this.logger.info("Saldo atual do Bibliotecário: " +this.bibliotecario.getCarteira());
    }

    @Test
    public void verificaMatriculaFalse(){
        bibliotecario.setMatricula("20210102");

        bibliotecario.addSaldoDeb(10);
        bibliotecario.addSaldoDeb(30);
        bibliotecario.retirarSaldoDeb(10);

        boolean validaMatricula = bibliotecario.validaMatricula();
        Assert.assertFalse(validaMatricula);
    }

    @Test
    public void verificaGerente(){
        Gerente gerente = new Gerente();
        gerente.setNome("Carlos");
        gerente.setEncarregados(List.of(new Pessoa[]{
                bibliotecario,
                new Professor(),
                new Estudante(),
                new Estudante()
        }));

        bibliotecario.setGerente(gerente);
        boolean verificaGerente = bibliotecario.verificaGerente();
        Assert.assertTrue(verificaGerente);
    }

    @Test
    public void verificaFaculdade(){
        Faculdade faculdade = new Faculdade();
        faculdade.setNome("FAFIC");

        bibliotecario.setFaculdade(faculdade);
        Assert.assertEquals("FAFIC", bibliotecario.getFaculdade().getNome());
    }

}
