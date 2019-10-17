package gherkin.hook;

import br.com.core.report.ExtentReports;
import br.com.core.setup.AppWeb;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import static br.com.core.setup.Drivers.closeDriver;
import static br.com.core.setup.Drivers.loadApplication;

public class Hook extends ExtentReports {

    @Before
    public void init(Scenario scenario) {
        testScenario.set(scenario);
        AppWeb appWeb = new AppWeb();
        appWeb.setTestName(testScenario.get().getName());
        appWeb.setBrowserName("chrome");
        appWeb.setUpDriver(appWeb);
        loadApplication(getBrowser(),"http://automationpractice.com/index.php");
    }

    @After
    public void cleanUp() {
        closeDriver(getBrowser());
    }
}









