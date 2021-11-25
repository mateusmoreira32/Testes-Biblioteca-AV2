package modulo4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

public class LivroTest {

    Livro livro;
    private final Logger logger = Logger.getLogger("my-Logger");

    @After
    public void printMessage(){
        this.logger.info("Início dos testes" );
    }

    @Test
    public void verificaNome(){
        livro = new Livro();
        livro.setNome("Harry Potter");

        Assert.assertEquals("Harry Potter", livro.getNome());
    }

    @Test
    public void verificarAutor(){
        livro = new Livro();
        livro.setAutor("Higor");

        Assert.assertEquals("Higor", livro.getAutor());
    }

    @Test
    public void verificarCodigoValido(){
        livro = new Livro();
        livro.setCodigo("123");

        Assert.assertNotNull(livro.getCodigo());
    }

    @Test
    public void verificarValorLivroValido(){
        livro = new Livro();
        livro.setValor(32.0);

        boolean verificaValor = livro.verificaValorLivro();

        Assert.assertTrue(verificaValor);
    }

    @Test
    public void verificarValorLivroInvalido(){
        livro = new Livro();
        livro.setValor(0);

        boolean verificaValor = livro.verificaValorLivro();

        Assert.assertFalse(verificaValor);
    }

}
