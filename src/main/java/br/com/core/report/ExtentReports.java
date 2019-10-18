package br.com.core.report;

import br.com.core.properties.PropertiesManager;
import br.com.core.setup.DriverManager;
import br.com.core.takescreenshot.TakeScreenShot;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;


public class ExtentReports extends DriverManager {

    private static PropertiesManager setupProperties = new PropertiesManager("Setup.properties");
    private static Logger LOGGER = Logger.getLogger("InfoLogging");
    private String complementNameEvidence;


    /**
     * Set evidence if the test is failed in last step
     */
    public static void logReportAllDrivers(WebDriver driver) {
        if (getBrowser() != null) {
            if (testScenario.get().isFailed()) {
                appendToReport(getBrowser());
            }
        }
    }

    /**
     * Add comment to the cucumber-extent report listener for generating ExtentReports and Klov
     *
     * @param sMsg Text to be added to the report
     */
    public static synchronized void appendToReport(String sMsg) {
        System.out.println("[FrameWork] " + sMsg);
        testScenario.get().write(sMsg);
    }

    /**
     * Add screenshot to the cucumber-extent report listener for generating ExtentReports and Klov
     */
    public static synchronized void appendToReport(WebDriver driver) {
        appendPrintCucumber(driver);
    }

    /**
     * Add comment and screenshot to the cucumber-extent report listener for generating ExtentReports and Klov
     *
     * @param sMsg Text to be added to the report
     */
    public static synchronized void appendToReport(WebDriver driver, String sMsg) {
        testScenario.get().embed(TakeScreenShot.getImageBytes(driver), "image/png");
        testScenario.get().write(sMsg);
        System.out.println("[FrameWork] " + sMsg);
    }

    /**
     * Support for function appendToReport, add a screenshot to the Cucumber Extent-Report
     */
    private synchronized static void appendPrintCucumber(WebDriver driver) {
        if (setupProperties.getProps().getProperty("GlobalEvidence").equalsIgnoreCase("true")) {
            testScenario.get().embed(TakeScreenShot.getImageBytes(driver), "image/png");
        }
    }


    /**
     * Set evidence if the test is failed in last step
     */
    public static void logReport(WebDriver driver) {
        if (driver != null) {
            if (testScenario.get().isFailed()) {
                ExtentReports.appendToReport(driver);
            }
        }
    }

    public String getComplementNameEvidence() {
        return complementNameEvidence;
    }

    public void setComplementEvidenceName(String complementNameEvidence) {
        this.complementNameEvidence = complementNameEvidence;
    }
}
