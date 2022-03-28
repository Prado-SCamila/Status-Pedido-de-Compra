package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

    // CORES.............................................................

    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BRIGHT_YELLOW = "\u001B[93m";
    public static final String ANSI_BRIGHT_BLUE = "\u001B[94m";

    public static final String ANSI_RESET = "\u001B[0m";
    // ......................................................................

    private Date momento;

    private StatusPedido status;

    // declaro que essa classe contém o objeto cliente
    private Cliente cliente;

    // declaro que essa classe contem uma lista dos status
    private List<ItemPedido> items = new ArrayList<ItemPedido>();

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Date getMomento() {
        return momento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public Pedido() {

    }

    public Pedido(Date momento, StatusPedido status, Cliente cliente) {
        super();
        this.momento = momento;
        this.status = status;
        this.cliente = cliente;
    }

    public void AddItem(ItemPedido item) {
        items.add(item);
    }

    public void RemoveItem(ItemPedido item) {
        items.remove(item);
    }

    public double Total() {

        double soma = 0.0;

        for (ItemPedido ipedido : items) {
            soma = soma + (ipedido.SubTotal());
        }
        return soma;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ANSI_BRIGHT_BLUE + "Data do pedido: " + ANSI_RESET);
        sb.append(sdf.format(momento) + "\n");
        sb.append(ANSI_BRIGHT_BLUE + "Status do pedido: " + ANSI_RESET);
        sb.append(status + "\n");
        sb.append(ANSI_BRIGHT_BLUE + "Cliente: ");
        sb.append(cliente + "\n");
        sb.append(ANSI_BRIGHT_BLUE + "Items do pedido:\n" + ANSI_RESET);
        for (ItemPedido item : items) {
            sb.append(item + "\n");
        }
        sb.append(ANSI_BRIGHT_BLUE + "Preço total: $" + ANSI_RESET);
        sb.append(String.format(ANSI_BRIGHT_YELLOW + Total() + ANSI_RESET));
        return sb.toString();
    }

}

// fazer esquema pra validação de email e data de nascimento