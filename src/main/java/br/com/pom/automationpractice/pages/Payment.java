package br.com.pom.automationpractice.pages;

import br.com.core.asserts.Verifications;
import br.com.core.report.ExtentReports;
import br.com.core.setup.DriverManager;
import br.com.core.view.Action;
import br.com.pom.automationpractice.constantes.Constantes;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class Payment extends DriverManager implements Constantes {

    private By lblValorProdutosTabela = By.xpath("//table[@id='cart_summary']//tfoot//tr/td[2]");
    private By btnPagametoBanco = By.className("bankwire");
    private By btnConfirmaOrdem = By.xpath("//p[@id='cart_navigation']//button");
    private By lblCompraSucesso = By.xpath("//p[@class='cheque-indent']");

    /**
     * Calcula valor total da compra conforme apresentado na tabela de valores
     */
    public void validarTotalPagamento(){
        Verifications.verifyElementExists(getBrowser(),btnPagametoBanco,timeOut);
        List<WebElement> valores = getBrowser().findElements(lblValorProdutosTabela);
        double somaValorCompra = 0;
        for (int i = 0; i < valores.size(); i++) {
            if(!valores.get(i).getText().isEmpty()){
                somaValorCompra =+ Double.parseDouble(valores.get(i).getText().replace("$",""));
            }else if (i == valores.size() - 1){
                Assert.assertEquals(somaValorCompra,Double.parseDouble(valores.get(i).getText().replace("$","")));
                break;
            }
        }
    }

    /**
     * Seleciona forma de pagamento conforme valor informado no gherkin
     * @param dataTable - Nome da forma de pagamento exemplo: Pay by bank wire, Pay by check.
     */
    public void selecionaMetodoPagamento(DataTable dataTable){
        List<Map<String,String>> table = dataTable.asMaps();
        ExtentReports.appendToReport(getBrowser());
        for (Map<String,String> row : table){
            for(String campo : row.keySet()){
                String resposta = row.get(campo);
                switch (campo.toUpperCase()){
                    case "METODO_PAGAMENTO":
                        Action.clickOnElement(getBrowser(),By.xpath("//a[@title='"+resposta+"']"),timeOut);
                        break;
                    default:
                        Assert.fail("Coluna não encontrada!");
                }
            }
        }
    }

    /**
     * Tira print e Clica no botão confirma oderm
     */
    public void confirmarOdermPagamento(){
        Verifications.verifyElementIsClickable(getBrowser(),btnConfirmaOrdem,timeOut);
        ExtentReports.appendToReport(getBrowser());
        Action.clickOnElement(getBrowser(),btnConfirmaOrdem,timeOut);
    }

    /**
     * Valida mensagem de sucesso para ordem de compra
     */
    public void validarCompraComSucesso(){
        Verifications.verifyTextsElementClickable(getBrowser(),lblCompraSucesso,"Your order on My Store is complete",timeOut);
        ExtentReports.appendToReport(getBrowser());
    }
}
