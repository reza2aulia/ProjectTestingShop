package com.rezaaulia.pages;

import com.rezaaulia.drivers.DriverSingeleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(){
        this.driver = DriverSingeleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"username\"]")
    WebElement username;
    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")
    WebElement btnLogin;
    @FindBy(xpath = "//*[@id=\"post-8\"]/div/div/div/p[1]")
    WebElement txtDashboard;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/h2")
    WebElement loginTitle;
    @FindBy(xpath = "//*[@id=\"post-8\"]/div/div/div[1]/ul/li")
    WebElement txtInvalidCredentials;

    public String getLoginTitle(){
        return loginTitle.getText();
    }
    public String getTxtDashboard(){
        return txtDashboard.getText();
    }
    public String getTxtInvalidCredentials(){
        return txtInvalidCredentials.getText();
    }
    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnLogin.click();
    }

}
