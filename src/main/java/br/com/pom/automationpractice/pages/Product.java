package br.com.pom.automationpractice.pages;

import br.com.core.asserts.Verifications;
import br.com.core.report.ExtentReports;
import br.com.core.setup.DriverManager;
import br.com.core.view.Action;
import br.com.core.view.FrameActions;
import br.com.pom.automationpractice.constantes.Constantes;
import org.openqa.selenium.By;

public class Product extends DriverManager implements Constantes {

    private By btnAddToCart = By.id("add_to_cart");
    private By btnProceedToCheckout = By.xpath("//a[@title='Proceed to checkout']");
    private By lblAddSucessoCarrinho = By.xpath("//div[contains(@class,'layer_cart_product')]//h2[1]");

    /**
     * Adiciona produto no carrinho
     */
    public void adicionaNoCarrinho(){
        Verifications.verifyElementIsClickable(getBrowser(),btnAddToCart, TIME_OUT);
        ExtentReports.appendToReport(getBrowser());
        getBrowser().findElement(btnAddToCart).click();
        Verifications.verifyElementIsClickable(getBrowser(),lblAddSucessoCarrinho, TIME_OUT);
        ExtentReports.appendToReport(getBrowser());
        Action.clickOnElement(getBrowser(),btnProceedToCheckout, TIME_OUT);

    }
}
