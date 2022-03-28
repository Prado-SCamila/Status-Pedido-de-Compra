package entities;

public class ItemPedido {

    private Integer quantidade;

    private Double preco;

    private Produto produto;

    public Integer getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public ItemPedido() {

    }

    public ItemPedido(Integer quantidade, Double preco, Produto produto) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.setProduto(produto);

    }

    public Double SubTotal() {

        return (quantidade * preco);
    }

    @Override
    public String toString() {
        return getProduto().getNomeProduto()
                + ", $"
                + preco
                + ", Quantity: "
                + quantidade
                + ", Subtotal: $"
                + SubTotal();
    }
}
