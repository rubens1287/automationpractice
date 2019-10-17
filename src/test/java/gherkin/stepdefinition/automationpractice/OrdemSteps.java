package gherkin.stepdefinition.automationpractice;

import br.com.pom.automationpractice.pages.Address;
import br.com.pom.automationpractice.pages.Order;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Quando;

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

    @Quando("seleciono o metodo de pagamento")
    public void seleciono_o_metodo_de_pagamento() {

    }



}
