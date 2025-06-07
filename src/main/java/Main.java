import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();
        List<Produto> produtos = new ArrayList<>();
        List<Venda> vendas = new ArrayList<>();

        usuarios.add(new Usuario("Vitor Araujo", "123.456.789-10", "vitoraraujo@email.com"));
        usuarios.add(new Usuario("Vitoria Tenorio", "109.876.543-21", "vitoriatenorio@email.com"));

        produtos.add(new Produto(1, "Notebook", 5000.0, 10));
        produtos.add(new Produto(2, "Impressora", 500.0, 20));
        produtos.add(new Produto(3, "Headset", 250.0, 30));

        Venda venda1 = new Venda(usuarios.get(0));
        venda1.adicionarItem(produtos.get(0), 1);
        venda1.adicionarItem(produtos.get(1), 2);
        vendas.add(venda1);

        Venda venda2 = new Venda(usuarios.get(1));
        venda2.adicionarItem(produtos.get(2), 1);
        venda2.adicionarItem(produtos.get(1), 5);
        vendas.add(venda2);

        System.out.println("\n-----Vendas atuais-----");
        for (Venda venda : vendas) {
            System.out.println(venda);
        }

        System.out.println("\n -----Estoque-----");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
}
