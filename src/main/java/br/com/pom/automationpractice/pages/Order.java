package br.com.pom.automationpractice.pages;

import br.com.core.asserts.Verifications;
import br.com.core.report.ExtentReports;
import br.com.core.setup.DriverManager;
import br.com.pom.automationpractice.constantes.Constantes;
import org.openqa.selenium.By;

public class Order extends DriverManager implements Constantes {

    private By btnProceedToCheckout = By.linkText("Proceed to checkout");
    private By ckbAgreeTerms = By.id("cgv");
    private By btnProcessCarrier = By.name("processCarrier");

    /**
     * Procede para criação da ordem de venda
     *
     */
    public void executaOrdemCompra(){
        Verifications.verifyElementExists(getBrowser(),btnProceedToCheckout, TIME_OUT);
        ExtentReports.appendToReport(getBrowser());
        getBrowser().findElement(btnProceedToCheckout).click();
    }

    /**
     *  Valida, tira print e confirma Termo de serviço
     */
    public void confirmarTermoDoServico(){
        Verifications.verifyElementExists(getBrowser(),ckbAgreeTerms, TIME_OUT);
        ExtentReports.appendToReport(getBrowser());
        getBrowser().findElement(ckbAgreeTerms).click();
    }

    /**
     * Confirma ordem de serviço.
     */
    public void confirmarOrdemServico(){
        getBrowser().findElement(btnProcessCarrier).click();
    }


}
