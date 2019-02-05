package com.PristaShop5.pages;

import com.PristaShop5.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddToCarts {
    public AddToCarts(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


@FindBy(xpath = "//div[@class='pb-center-column col-xs-12 col-sm-4']/h1" )
    public WebElement nameAfterAddProduct;
    @FindBy(id="quantity_wanted")
    public WebElement defaultQuantity;
    @FindBy(xpath = "//span[@style='width: 228px; user-select: none;']")
    public WebElement defaultSize;
    @FindBy(xpath = "//select[@class='form-control attribute_select no-print']/option")
    public List< WebElement> sizes;
    @FindBy(xpath = "//select[@class='form-control attribute_select no-print']")
    public  WebElement selectElement;

    public Select selects(){
    Select select= new Select(selectElement);
    return select;
}
    @FindBy(xpath = "(//button[@type='submit'])[3]")
    public WebElement addAProductToTheCart;
    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
    public WebElement hoverOverCart1;
    @FindBy(xpath = "//i[@class='icon-plus']")
    public WebElement addIcon;//(adding different quantity)
    @FindBy(xpath = "//div[@class='layer_cart_product col-xs-12 col-md-6']/h2")
    public WebElement succesMessage;
    @FindBy(xpath = "//span[@class='cross']")
    public WebElement xbutton;
    @FindBy(xpath ="//img[@class='logo img-responsive']")
    public WebElement companyLogo;
    @FindBy(xpath = "(//span[@class='price'])[1]")
    public WebElement pricePdt1;
    @FindBy(xpath = "(//span[@class='price'])[2]")
    public WebElement pricePdt2;
    @FindBy(xpath = "//span[@class='price cart_block_total ajax_block_cart_total']")
    public WebElement totalPrice;
    @FindBy(xpath = "//div[@class='cart-prices-line first-line']/span[1]")
    public WebElement shippingPrice;
    @FindBy(xpath = "//span[@class='quantity']")
    public List<WebElement> cartQuantitiy;
    @FindBy(css = "div.product-name>a")
    public WebElement productnameInTheCart;
    @FindBy(xpath = "//div[@class='header_user_info']")
    public WebElement sigIn;
    @FindBy(xpath = "(//a[@class='btn btn-default button button-small'])[2]")
    public WebElement backToHomePage;
    @FindBy(xpath = "//a[@class='logout']")
    public WebElement logout;
    @FindBy(xpath = "//p[@class='alert alert-warning']")
    public WebElement emptyMessage;
    @FindBy(xpath = "//div[@class='button-container']/a")
    public WebElement proceedtocart;
    @FindBy(xpath = "//i[@class='icon-chevron-left left']")
    public WebElement continueshopping;
    @FindBy(xpath = "//div[@class='shopping_cart']/a/span[5]")
    public WebElement emptyMessageInTheCart;
    @FindBy(xpath = "//a[@class='ajax_cart_block_remove_link']")
    public WebElement xIconOnTheCart;
    @FindBy(xpath = "//span[@class='heading-counter']")
    public WebElement messageOfCartContent;

    @FindBy(xpath = "(//i[@class='icon-trash'])[1]")
    public WebElement delete1Pdt;

}
