package com.rezaaulia.drivers;

import com.rezaaulia.drivers.strategies.DriverStrategy;
import com.rezaaulia.drivers.strategies.DriverStrategyImplementer;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingeleton {
    private static DriverSingeleton instance = null;
    private static WebDriver driver;
    private DriverSingeleton(String driver){
        instantiate(driver);
    }

    public WebDriver instantiate(String stategy){
        DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(stategy);
        driver = driverStrategy.setStrategy();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static DriverSingeleton getInstance(String driver){
        if(instance == null){
            instance = new DriverSingeleton(driver);
        }
        return instance;
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void closeObjectInstance(){
        instance = null;
        driver.quit();
    }
}