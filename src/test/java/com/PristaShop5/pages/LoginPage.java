package com.PristaShop5.pages;

import com.PristaShop5.Utilities.ConfigurationReader;
import com.PristaShop5.Utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath= "//div[@class='header_user_info']/a")
    public WebElement SignInButton;

    @FindBy(xpath = "(//input[@class='is_required validate account_input form-control'])[2]")
    public WebElement emailaddress;
    @FindBy(xpath = "(//input[@class='is_required validate account_input form-control'])[3]")
    public WebElement password;


    public void login(){
        this.SignInButton.click();
        this.emailaddress.sendKeys(ConfigurationReader.getProperty("username"));
        this.password.sendKeys(ConfigurationReader.getProperty("password")+ Keys.ENTER);

    }

    @FindBy(xpath = "//span[@class='navigation_page']")
    public WebElement myAccount;
    @FindBy(xpath = "//span[.='Meron Tesfay']")
    public WebElement nameOnTop;
    @FindBy(xpath = "//span[.='My personal information']")
    public WebElement mypersonalInfoButton;
    public WebElement firstname;
    @FindBy(id = "lastname")
    public WebElement lastName;
    @FindBy(xpath = "(//i[@class='icon-chevron-right right'])[3]")
    public WebElement saveButton;
    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
    public WebElement errorMessage;
    @FindBy(xpath = "(//i[@class='icon-chevron-left'])[1]")
    public WebElement backToAccount;
    @FindBy(xpath = "//span[.='My addresses']")
    public WebElement myaddress;
    @FindBy(xpath = "//span[.='Add a new address']")
    public WebElement addNewAddres;

    //REGISTRATION========
    @FindBy(id = "email_create")
    public WebElement EmailToCreateNewAccount;
    @FindBy(id = "customer_firstname")
    public WebElement firstNameToRegister;
    @FindBy(id="customer_lastname")
    public WebElement lastnameToRegister;
    @FindBy(id="passwd")
    public WebElement NewPasswordToRegister;
    @FindBy(id="address1")
    public WebElement addresss;
    @FindBy(id="city")
    public WebElement city;
    @FindBy(id="id_state")
    public WebElement state;
    @FindBy(id = "postcode")
    public WebElement zipCode;
    @FindBy(id = "phone_mobile")
    public WebElement phoneNum;
    @FindBy(xpath = "(//i[@class='icon-chevron-right right'])[3]")
    public WebElement registerButton;
    @FindBy(xpath = "//div[@class='header_user_info']//span")
    public WebElement nameOnToppofAccount;
    @FindBy(xpath = "//span[.='My personal information']")
    public WebElement clickOnpersonalInfo;
    @FindBy(id = "firstname")
    public WebElement checkFirstName;
    @FindBy(id = "lastname")
    public WebElement checkLastName;
    @FindBy(xpath = "(//input[@class='is_required validate form-control'])[3]")
    public WebElement Checkemail;
    @FindBy(xpath = "//span[.='My addresses']")
    public WebElement clickOnAddress;
    @FindBy(xpath = "(//span[@class='address_name'])[1]")
    public WebElement NameOnTheAddress;
    @FindBy(xpath = "(//span[@class='address_name'])[2]")
    public WebElement lastNameOnTheAddress;
    @FindBy(xpath = "//span[@class='address_address1']")
    public WebElement streetAddress;
    @FindBy(xpath = "(//div[@class='col-xs-12 col-sm-6 address']/ul/li)[5]")
    public WebElement allAddress;
    @FindBy(xpath = "//a[@class='logout']")
    public WebElement signOutLink;
    @FindBy(xpath = "(//input[@class='is_required validate account_input form-control'])[2]")
    public WebElement loginUsingValidEmail;
    @FindBy(xpath = "(//input[@class='is_required validate account_input form-control'])[3]")
    public WebElement loginUsingValidPass;







}
