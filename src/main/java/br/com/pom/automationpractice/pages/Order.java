package br.com.pom.automationpractice.pages;

import br.com.core.asserts.Verifications;
import br.com.core.report.ExtentReports;
import br.com.core.setup.DriverManager;
import br.com.pom.automationpractice.constantes.Constantes;
import org.openqa.selenium.By;

public class Order extends DriverManager implements Constantes {

    private By btnProceedToCheckout = By.linkText("Proceed to checkout");
    private By ckbAgreeTerms = By.id("cgv");

    /**
     * Procede para criação da ordem de venda
     *
     */
    public void executaOrdemCompra(){
        Verifications.verifyElementExists(getBrowser(),btnProceedToCheckout,timeOut);
        ExtentReports.appendToReport(getBrowser());
        getBrowser().findElement(btnProceedToCheckout).click();
    }

    public void confirmarTermoDoServico(){
        Verifications.verifyElementIsClickable(getBrowser(),ckbAgreeTerms,timeOut);
        ExtentReports.appendToReport(getBrowser());
        getBrowser().findElement(ckbAgreeTerms).click();
    }

    public void confirmarOrdemServico(){
        getBrowser().findElement(btnProceedToCheckout).click();
        getBrowser().findElement(btnProceedToCheckout).click();
    }


}
