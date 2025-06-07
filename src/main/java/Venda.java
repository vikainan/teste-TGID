import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {
    private Usuario cliente;
    private List<ItemVenda> itens;
    private Date data;

    public Venda(Usuario cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.data = new Date();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (produto.reduzirEstoque(quantidade)) {
            itens.add(new ItemVenda(produto, quantidade));
        } else {
            System.out.println("Estoque insuficiente para o item " + produto.getNome());
        }
    }

    public double getTotal() {
        double total = 0;
        for (ItemVenda item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }


    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String resultado = "Venda para " + cliente + "\n";
        resultado += "Data: " + sdf.format(data) + "\n";
        resultado += "Itens: \n";

        for (ItemVenda item : itens) {
            resultado += " - " + item + "\n";
        }
        resultado += "Total: R$" + getTotal() + "\n";

        return resultado;
    }
}
