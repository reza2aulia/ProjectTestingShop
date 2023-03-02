package com.rezaaulia;


import com.rezaaulia.drivers.DriverSingeleton;
import com.rezaaulia.pages.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogin {

    public static WebDriver driver;
    public LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        DriverSingeleton.getInstance("chrome");
        driver = DriverSingeleton.getDriver();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void testUrl(){
        driver.get("https://shop.demoqa.com/my-account/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        //step verify
        Assert.assertEquals(loginPage.getLoginTitle(),"Login");
    }

    @Test(priority = 3)
    public void testValidLogin(){
        loginPage.login("reza2aulia","aulia280195");
        Assert.assertEquals(loginPage.getTxtDashboard(),"Dashboard");
    }

    @Test(priority = 2)
    public void testInvalidLogin(){
        loginPage.login("reza2aulia","admin1234");
        Assert.assertEquals(loginPage.getTxtInvalidCredentials(),"Invalid credentials");
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

