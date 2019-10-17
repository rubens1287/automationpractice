package gherkin.stepdefinition.automationpractice;

import br.com.pom.automationpractice.pages.Account;
import br.com.pom.automationpractice.pages.Login;
import cucumber.api.java.pt.Quando;

public class CadastroClienteSteps {

    private Login login = new Login();
    private Account account = new Account();

    @Quando("realizo o cadastro do cliente")
    public void realizo_o_cadastro_do_cliente() {
        login.validaTelaLogin();
        login.criaConta();
        account.validaTelaCadastroCliente();
        account.preencherDadosCliente();
    }

}
