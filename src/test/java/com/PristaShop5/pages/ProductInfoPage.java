package com.PristaShop5.pages;

import com.PristaShop5.Utilities.ConfigurationReader;
import com.PristaShop5.Utilities.Driver;
import com.PristaShop5.Utilities.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class ProductInfoPage  extends TestBase {
    public ProductInfoPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



@FindBy(xpath = "//ul[@id='homefeatured']//a[@class='product-name']/..//following-sibling::div/span[@class='price product-price']")
public List<WebElement> productPrice;

@FindBy(xpath = "//ul[@id='homefeatured']//h5")
    public List<WebElement>productName;

@FindBy(xpath = "//ul[@id='homefeatured']//li/div")
    public List<WebElement>clickAnyPdt;

}