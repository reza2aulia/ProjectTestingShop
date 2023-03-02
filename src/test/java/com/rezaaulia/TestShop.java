package com.rezaaulia;

import com.rezaaulia.drivers.DriverSingeleton;
import com.rezaaulia.pages.ShopPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestShop {
    public static WebDriver driver;

    public ShopPage shopPage;

    @BeforeClass
    public void setUp(){
        DriverSingeleton.getInstance("chrome");
        driver = DriverSingeleton.getDriver();
        shopPage = new ShopPage();
        driver.get("https://shop.demoqa.com");
    }

    @Test
    public void testAddCandidate(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");


    }

    @AfterClass
    public void quitBrowser(){
        delay(3);
        DriverSingeleton.closeObjectInstance();
    }

    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

