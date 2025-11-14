/**
 * Classe que representa um item em uma venda.
 */
public class ItemVenda {
    private Produto produto;
    private int quantidade;

    /**
     * Construtor.
     * @param produto O produto vendido.
     * @param quantidade A quantidade do produto.
     */
    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    /**
     * Calcula o subtotal do item.
     * @return O valor total deste item (preço * quantidade).
     */
    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }
}
