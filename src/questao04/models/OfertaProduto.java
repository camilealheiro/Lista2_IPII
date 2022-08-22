package questao04.models;

import java.time.LocalDate;

public class OfertaProduto implements Comparable<OfertaProduto>{

    private Produto produto;
    private Float preco;
    private Loja lojaOFertante;
    private LocalDate data;

    public OfertaProduto(Produto produto, float preco, Loja lojaOFertante,
                         LocalDate data) {
        this.produto = produto;
        this.preco = preco;
        this.lojaOFertante = lojaOFertante;
        this.data = data;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Loja getLojaOFertante() {
        return lojaOFertante;
    }

    public void setLojaOFertante(Loja lojaOFertante) {
        this.lojaOFertante = lojaOFertante;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String tela = String.format("%n%s%n", "/*Oferta Produto*/");
        //tela += String.format("|Produto: %s%n|Preco: %", )
        tela += produto + "|Preco = " + preco + "\n|Data = " + data + "\n"+ lojaOFertante;
        tela += "------------------------------------------\n";
        return tela;
    }

    @Override
    public int compareTo(OfertaProduto outro) {
        return preco.compareTo(outro.getPreco());
    }
}