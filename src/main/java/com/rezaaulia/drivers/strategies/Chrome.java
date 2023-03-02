package com.rezaaulia.drivers.strategies;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements DriverStrategy {
    @Override
    public WebDriver setStrategy(){
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.setExperimentalOption("useAutomationExtension", false);
        option.addArguments("--no-sandbox");
        return new ChromeDriver(option);
    }
}