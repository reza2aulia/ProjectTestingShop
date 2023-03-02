package com.rezaaulia.pages;

import com.rezaaulia.drivers.DriverSingeleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {
    private WebDriver driver;
    public ShopPage(){
        this.driver = DriverSingeleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/h3/a")
    WebElement SelectItem;



}