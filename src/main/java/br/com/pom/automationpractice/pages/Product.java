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
    private By iFrameProduto = By.className("fancybox-iframe");

    /**
     * Adiciona produto no carrinho
     */
    public void adicionaNoCarrinho(){
        FrameActions.switchToFrame(getBrowser(),iFrameProduto,timeOut);
        Verifications.verifyElementIsClickable(getBrowser(),btnAddToCart,timeOut);
        ExtentReports.appendToReport(getBrowser());
        getBrowser().findElement(btnAddToCart).click();
        Verifications.verifyElementIsClickable(getBrowser(),lblAddSucessoCarrinho,timeOut);
        ExtentReports.appendToReport(getBrowser());
        Action.clickOnElement(getBrowser(),btnProceedToCheckout,timeOut);

    }
}
