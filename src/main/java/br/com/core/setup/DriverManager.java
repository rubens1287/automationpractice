package br.com.core.setup;

import cucumber.api.Scenario;
import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    public static ThreadLocal<Scenario> testScenario = new ThreadLocal<Scenario>();
    private static ThreadLocal<WebDriver> browser = new ThreadLocal<>();
    private static Process process;

    public static Process getProcess() {return process;}

    public static void setProcess(Process process) {DriverManager.process = process;}

    public static WebDriver getBrowser() {
        return browser.get();
    }

    public static void setBrowser(WebDriver browser) {DriverManager.browser.set(browser); }
}
