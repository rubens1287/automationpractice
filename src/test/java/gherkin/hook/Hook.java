package gherkin.hook;

import br.com.core.report.ExtentReports;
import br.com.core.setup.AppWeb;
import br.com.pom.automationpractice.constantes.Constantes;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import static br.com.core.setup.Drivers.closeDriver;

public class Hook extends ExtentReports implements Constantes {

    @Before
    public void init(Scenario scenario) {
        testScenario.set(scenario);
        AppWeb appWeb = new AppWeb();
        appWeb.setTestName(testScenario.get().getName());
        appWeb.setUpDriver(appWeb);
    }

    @After
    public void cleanUp() {
        closeDriver(getBrowser());
    }
}









