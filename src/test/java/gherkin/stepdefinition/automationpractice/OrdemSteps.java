package gherkin.stepdefinition.automationpractice;

import br.com.pom.automationpractice.pages.Address;
import br.com.pom.automationpractice.pages.Order;
import br.com.pom.automationpractice.pages.Payment;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Quando;
import io.cucumber.datatable.DataTable;

public class OrdemSteps {

    private Order order = new Order();
    private Address address = new Address();


    @E("confirma endereco de recebimento")
    public void confirmaEnderecoDeRecebimento() {
        address.confirmarEndereco();
    }

    @E("aceita termo da Ordem de Servico")
    public void aceitaTermoDaOrdemDeServico() {
        order.confirmarTermoDoServico();
        order.confirmarOrdemServico();
    }

}
