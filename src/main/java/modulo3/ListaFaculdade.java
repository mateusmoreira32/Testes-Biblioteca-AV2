package modulo3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaFaculdade {

    private List<Faculdade> faculdades;

    public ListaFaculdade() {
        this.faculdades = new ArrayList<>();
    }

    public List<Faculdade> getFaculdades() {
        return faculdades;
    }

    public void setFaculdades(List<Faculdade> faculdades) {
        this.faculdades = faculdades;
    }

    public Faculdade pesquisarPorNome(String nome){
        return faculdades.stream().filter(f -> f.getNome().equals(nome)).findFirst().orElse(null);
    }

    public List<Faculdade> filtarPorNome(String nome){
        return faculdades.stream().filter(f -> f.getNome().contains(nome)).collect(Collectors.toList());
    }
}
