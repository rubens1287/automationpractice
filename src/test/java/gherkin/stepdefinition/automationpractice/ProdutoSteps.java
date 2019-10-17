package gherkin.stepdefinition.automationpractice;

import br.com.pom.automationpractice.pages.Index;
import br.com.pom.automationpractice.pages.Order;
import br.com.pom.automationpractice.pages.Product;
import cucumber.api.java.pt.Quando;
import io.cucumber.datatable.DataTable;

public class ProdutoSteps {

    private Index index = new Index();
    private Product produto = new Product();
    private Order order = new Order();

    @Quando("eu adicionar um produto no carrinho")
    public void eu_adicionar_um_produto_no_carrinho(DataTable dataTable) {
        index.escolheProduto(dataTable);
        produto.adicionaNoCarrinho();
        order.executaOrdemCompra();
    }
}
