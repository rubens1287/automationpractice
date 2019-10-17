package gherkin.stepdefinition.automationpractice;

import br.com.pom.automationpractice.pages.Index;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.cucumber.datatable.DataTable;

public class IndexSteps {


    private Index index = new Index();

    @Dado("eu estou na pagina incial")
    public void eu_estou_na_pagina_incial() {
        index.validaTelaIncial();
    }


    @Quando("confirmo a compra")
    public void confirmo_a_compra() {

    }

    @Entao("valido se a compra foi realizda com sucesso")
    public void valido_se_a_compra_foi_realizda_com_sucesso() {

    }

}
