/**
 * Classe Controller para as operações do sistema de vendas.
 * 
 * Aplica o padrão GRASP Controller:
 * É o primeiro objeto a receber e coordenar uma operação do sistema
 * (simulada aqui pelos métodos publicos), delegando a responsabilidade
 * para os objetos de domínio (Venda).
 */
public class SistemaVendasController {
    private Venda vendaAtual;

    /**
     * Inicia uma nova venda.
     * 
     * Controller: Recebe a requisição de iniciar a venda e coordena a criação
     * do objeto de domínio Venda.
     */
    public void iniciarNovaVenda() {
        this.vendaAtual = new Venda();
        System.out.println("Nova venda iniciada.");
    }

    /**
     * Adiciona um item à venda atual.
     * 
     * Controller: Recebe a requisição e delega a responsabilidade de adicionar
     * o item ao objeto de domínio Venda.
     * 
     * @param produto O produto a ser adicionado.
     * @param quantidade A quantidade.
     */
    public void adicionarItemAVenda(Produto produto, int quantidade) {
        if (vendaAtual == null) {
            System.out.println("Erro: Nenhuma venda ativa. Inicie uma nova venda primeiro.");
            return;
        }
        // Delega a responsabilidade para o objeto de domínio Venda
        vendaAtual.adicionarItem(produto, quantidade);
        System.out.println("Item adicionado: " + produto.getNome() + " x" + quantidade);
    }

    /**
     * Finaliza a venda e exibe o total.
     * 
     * Controller: Recebe a requisição e delega o cálculo ao objeto de domínio Venda.
     */
    public void finalizarVenda() {
        if (vendaAtual == null) {
            System.out.println("Erro: Nenhuma venda ativa para finalizar.");
            return;
        }
        double total = vendaAtual.calcularTotal();
        System.out.println("\n--- Resumo da Venda ---");
        for (ItemVenda item : vendaAtual.getItens()) {
            System.out.printf("%s (x%d): R$ %.2f\n", item.produto.getNome(), item.quantidade, item.getSubtotal());
        }
        System.out.printf("Total da Venda: R$ %.2f\n", total);
        System.out.println("----------------------\n");
        this.vendaAtual = null; // Limpa a venda atual
    }
}
