package modulo4;

import conexao.Conexao;
import modulo3.Biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class Livro {

    private String codigo;
    private String nome;
    private String autor;
    private double valor;
    private Biblioteca biblioteca;

    public Livro() {
    }

    public Livro(String codigo, String nome, String autor, double valor, Biblioteca biblioteca) {
        this.codigo = codigo;
        this.nome = nome;
        this.autor = autor;
        this.valor = valor;
        this.biblioteca = biblioteca;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public boolean verificaValorLivro(){
        if(this.valor > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(codigo, livro.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    public boolean salvarLivro(){
        {
            try {
                int bibliotecaID = this.getBiblioteca().findIdByName();

                Connection myConnection = Conexao.getConnection();
                String sql = "insert into livro (CODIGO, NOME, AUTOR, VALOR, BIBLIOTECA) values (?, ?, ?, ?, ?)";
                PreparedStatement preparableStatement = myConnection.prepareStatement(sql);
                preparableStatement.setString(1, this.getCodigo());
                preparableStatement.setString(2, this.getNome());
                preparableStatement.setString(3, this.getAutor());
                preparableStatement.setString(4, String.valueOf(this.getValor()));
                preparableStatement.setString(5, String.valueOf(bibliotecaID));
                preparableStatement.execute();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
