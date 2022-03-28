package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entities.Produto;
import entities.StatusPedido;
import entities.ItemPedido;
import entities.Pedido;
import entities.Cliente;

public class App {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println(" Registrar um novo Pedido");

        System.out.println("Digite os dados do cliente:"); // DADOS DO CLIENTE

        System.out.println("Nome: ");
        String nome = sc.next();

        System.out.println("Email: ");
        String email = sc.next();
        // ___________________________________________________________________________________________________________________
        // __________________VALIDAÇÃO DO EMAIL
        //
        // String regex = "^(.+)@(.+)$"; // apenas avalia se tem @
        // String regex = "^[A-Za-z0-9+_.-]+@(.+)$"; // avalia se tem @ e nome de
        // usuário escrito antes
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
        // // mais
        // completa
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        do {
            System.out.println("Digite um email válido. Exemplo : John@email.com");
            email = sc.next();
            matcher = pattern.matcher(email); // Refaz a verificação se o email atende ao padrão.
        } while (matcher.matches() == false);

        // ___________________________________________________________________________________________________________________

        System.out.println("Data Nascimento: exemplo dd/MM/yy ");
        Date birthdate = sdf.parse(sc.next());

        Cliente cliente = new Cliente(nome, email, birthdate); // OBJETO CLIEmiNTE INSTANCIADO

        System.out.println("____________________________________________________________________");
        System.out.println("-Pedido "); // DADOS DO PEDIDO
        System.out.println("\nStatus ");
        StatusPedido status = StatusPedido.valueOf(sc.next()); // converte enum em string
        System.out.println("\nQuantos itens neste pedido?  ");
        Integer n = sc.nextInt();

        Pedido pedido = new Pedido(new Date(), status, cliente); // OBJETO PEDIDO INSTANCIADO

        for (int i = 0; i < n; i++) { // INÌCIO DO LOOP

            System.out.println("Insira os dados do item " + (i + 1)); // DADOS DE CADA ITEM
            System.out.println("Nome: ");
            String nomeProduto = sc.next();
            System.out.println("Preço: ");
            Double preco = sc.nextDouble();
            System.out.println("Quantidade: ");
            Integer quantidade = sc.nextInt();

            Produto produto = new Produto(nomeProduto, preco); // OBJETO PRODUTO INSTANCIADO
            ItemPedido ipo = new ItemPedido(quantidade, preco, produto); // OBJETO ITEM PEDIDO INSTANCIADO

            pedido.AddItem(ipo); // ADICIONO O ITEM PEDIDO A LISTA
            System.out.println("..........................................................");
        }

        System.out.println();
        System.out.println(pedido);// ESCREVE NA TELA O PEDIDO COMPLETO COM TODOS OS ITEMS

        sc.close();

    }
}
