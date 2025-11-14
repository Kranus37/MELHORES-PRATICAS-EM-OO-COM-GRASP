/**
 * Classe principal para demonstrar a aplicação dos padrões GRASP Creator e Controller.
 */
public class Main {
    public static void main(String[] args) {
        // 1. Configuração inicial (simulação de um catálogo de produtos)
        Produto p1 = new Produto("Notebook", 3500.00);
        Produto p2 = new Produto("Mouse", 80.00);
        Produto p3 = new Produto("Teclado", 150.00);

        // 2. Criação do Controller
        SistemaVendasController controller = new SistemaVendasController();

        // 3. Simulação de uma sequência de operações do sistema (Controller em ação)
        
        // Iniciar Venda
        controller.iniciarNovaVenda(); 

        // Adicionar Itens
        controller.adicionarItemAVenda(p1, 1); // Controller recebe e delega
        controller.adicionarItemAVenda(p2, 2); // Controller recebe e delega
        controller.adicionarItemAVenda(p3, 1); // Controller recebe e delega

        // Finalizar Venda
        controller.finalizarVenda();
        
        // Simulação de uma segunda venda
        controller.iniciarNovaVenda();
        controller.adicionarItemAVenda(p2, 5);
        controller.finalizarVenda();
    }
}
