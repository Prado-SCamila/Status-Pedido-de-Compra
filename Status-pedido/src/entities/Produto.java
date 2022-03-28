package entities;

public class Produto {

    private String nomeProduto;

    private Double preco;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Produto() {

    }

    public Produto(String nomeProduto, Double preco) {

        this.nomeProduto = nomeProduto;
        this.preco = preco;
    }

}
