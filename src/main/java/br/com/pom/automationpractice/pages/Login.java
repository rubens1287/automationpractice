package br.com.pom.automationpractice.pages;

import br.com.core.asserts.Verifications;
import br.com.core.report.ExtentReports;
import br.com.core.setup.DriverManager;
import br.com.core.view.Action;
import br.com.pom.automationpractice.constantes.Constantes;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;

import java.util.Locale;

import static br.com.core.strings.StringUtils.unaccent;

public class Login extends DriverManager implements Constantes {

    private By txtEmail = By.id("email_create");
    private By btnCriarConta = By.id("SubmitCreate");
    private Faker faker = new Faker(new Locale("pt-BR"));


    /**
     * Valida se a pagina de login foi apresentada
     */
    public void validaTelaLogin(){
        Verifications.verifyElementIsClickable(getBrowser(),txtEmail, TIME_OUT);
        ExtentReports.appendToReport(getBrowser());
    }

    /**
     * Cria conta via pagina de login
     */
    public void criaConta(){
        Action.setText(getBrowser(),txtEmail,unaccent(faker.name().username())+"@gmail.com", TIME_OUT);
        ExtentReports.appendToReport(getBrowser());
        getBrowser().findElement(btnCriarConta).click();
    }

}
