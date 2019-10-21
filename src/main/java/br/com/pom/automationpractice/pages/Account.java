package br.com.pom.automationpractice.pages;

import br.com.core.asserts.Verifications;
import br.com.core.report.ExtentReports;
import br.com.core.setup.DriverManager;
import br.com.pom.automationpractice.constantes.Constantes;
import br.com.pom.automationpractice.model.DadosCliente;
import org.openqa.selenium.By;

public class Account extends DriverManager implements Constantes {

    private By txtPrimeiroNome = By.id("customer_firstname");
    private By txtUltimoNome = By.id("customer_lastname");
    private By txtPass = By.id("passwd");
    private By txtEmpresaPrimeroNome = By.id("firstname");
    private By txtEmpresaUltimoNome = By.id("lastname");
    private By txtEmpresaEndereco = By.id("address1");
    private By txtEmpresaCidade = By.id("city");
    private By cbbEmpresaEstado = By.id("id_state");
    private By txtEmpresaCep = By.id("postcode");
    private By cbbEmpresaPais = By.id("id_country");
    private By txtNumeroCelular = By.id("phone_mobile");
    private By txtReferenciaEndereco = By.id("alias");
    private By btnRegister = By.id("submitAccount");

    /**
     * Valida se a tela de cadastro esta sendo apresentada
     */
    public void validaTelaCadastroCliente(){
        Verifications.verifyElementIsClickable(getBrowser(),txtPrimeiroNome, TIME_OUT);
        ExtentReports.appendToReport(getBrowser());
    }

    /**
     * Peenche formularios de cadastro de novos clientes
     */
    public void preencherDadosCliente(){
        DadosCliente dadosCliente = new DadosCliente();
        getBrowser().findElement(txtPrimeiroNome).sendKeys(dadosCliente.getPrimeiroNome());
        getBrowser().findElement(txtUltimoNome).sendKeys(dadosCliente.getUltimoNome());
        getBrowser().findElement(txtPass).sendKeys(dadosCliente.getPass());
        getBrowser().findElement(txtEmpresaPrimeroNome).sendKeys(dadosCliente.getPrimeiroNome());
        getBrowser().findElement(txtEmpresaUltimoNome).sendKeys(dadosCliente.getUltimoNome());
        getBrowser().findElement(txtEmpresaEndereco).sendKeys(dadosCliente.getEndereco());
        getBrowser().findElement(txtEmpresaCidade).sendKeys(dadosCliente.getCidade());
        getBrowser().findElement(cbbEmpresaEstado).sendKeys("Arkansas");
        getBrowser().findElement(txtEmpresaCep).sendKeys("00000");
        getBrowser().findElement(cbbEmpresaPais).sendKeys("United States");
        getBrowser().findElement(txtNumeroCelular).sendKeys("11947460912");
        getBrowser().findElement(txtReferenciaEndereco).sendKeys(dadosCliente.getEndereco());
        ExtentReports.appendToReport(getBrowser());
        getBrowser().findElement(btnRegister).click();
    }



}
