package gherkin.stepdefinition.automationpractice;

import br.com.pom.automationpractice.pages.Payment;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.cucumber.datatable.DataTable;

public class PagamentoSteps {

    private Payment payment = new Payment();

    @Quando("seleciono o metodo de pagamento")
    public void seleciono_o_metodo_de_pagamento(DataTable dataTable) {
        payment.validarTotalPagamento();
        payment.selecionaMetodoPagamento(dataTable);
    }

    @Quando("confirmo a compra")
    public void confirmo_a_compra() {
        payment.confirmarOdermPagamento();
    }

    @Entao("valido se a compra foi realizada com sucesso")
    public void validoSeACompraFoiRealizadaComSucesso() {
        payment.validarCompraComSucesso();
    }
}
