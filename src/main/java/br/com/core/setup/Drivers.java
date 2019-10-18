package br.com.core.setup;


import br.com.core.properties.PropertiesManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static br.com.core.report.ExtentReports.logReport;

public abstract class Drivers {

    protected PropertiesManager setupProperties;

    /**
     * Loads the application on the WebApp
     *
     * @param url set url to load application on the browser
     */
    public static void loadApplication(@NotNull WebDriver driver, String url) {
        PropertiesManager setupProperties = new PropertiesManager("Setup.properties");
        driver.get(url);
        waitPageLoad(driver, setupProperties.getProps().getProperty("Implicit.Wait"));
    }

    /**
     * Deletes the cookies from the browser
     *
     * @author Rubens Lobo
     */
    public static void deleteCookies(@NotNull WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    /**
     * Sets the default timeout in seconds for the page to load on WebApp
     *
     * @param seconds amount of seconds to wait for the page load in WebApp
     * @author Rubens Lobo
     */
    private static void waitPageLoad(@NotNull WebDriver driver, String seconds) {
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(seconds), TimeUnit.SECONDS);
    }

    /**
     * Close driver
     *
     * @author Rubens Lobo
     */
    public static synchronized  void closeDriver(WebDriver driver) {

        if (driver != null) {
            logReport(driver);
            driver.quit();
        }
    }

    public abstract void setUpDriver(Drivers driver);

}

