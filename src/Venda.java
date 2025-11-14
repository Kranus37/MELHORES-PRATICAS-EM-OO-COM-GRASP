import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma Venda.
 * 
 * Aplica o padrão GRASP Creator:
 * A classe Venda é responsável por criar instâncias de ItemVenda,
 * pois Venda agrega ItemVenda e contém os dados necessários para a criação
 * (o Produto e a quantidade).
 */
public class Venda {
    private List<ItemVenda> itens;

    public Venda() {
        this.itens = new ArrayList<>();
    }

    /**
     * Adiciona um novo item à venda.
     * 
     * Aplicação do padrão Creator:
     * A Venda cria o ItemVenda, pois ItemVenda é parte da Venda.
     * 
     * @param produto O produto a ser adicionado.
     * @param quantidade A quantidade do produto.
     */
    public void adicionarItem(Produto produto, int quantidade) {
        // Creator: Venda cria ItemVenda
        ItemVenda novoItem = new ItemVenda(produto, quantidade);
        this.itens.add(novoItem);
    }

    /**
     * Calcula o total da venda.
     * @return O valor total da venda.
     */
    public double calcularTotal() {
        double total = 0;
        for (ItemVenda item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }
}
