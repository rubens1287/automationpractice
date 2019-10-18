package br.com.pom.automationpractice.pages;

import br.com.core.asserts.Verifications;
import br.com.core.report.ExtentReports;
import br.com.core.setup.DriverManager;
import br.com.pom.automationpractice.constantes.Constantes;
import org.openqa.selenium.By;

public class Address extends DriverManager implements Constantes {

    private By btnProceedToCheckout = By.name("processAddress");

    /**
     * Valida se a pagina de Endereço foi apresentada
     */
    public void validaTelaLogin(){
        Verifications.verifyElementIsClickable(getBrowser(),btnProceedToCheckout,timeOut);
        ExtentReports.appendToReport(getBrowser());
    }

    /**
     * Clica no botão para confirma o endereço
     */
    public void confirmarEndereco(){
        getBrowser().findElement(btnProceedToCheckout).click();
    }

}
