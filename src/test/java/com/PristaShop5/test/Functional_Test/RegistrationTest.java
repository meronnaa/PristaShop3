package com.PristaShop5.test.Functional_Test;

import com.PristaShop5.Utilities.BrowserUtils;
import com.PristaShop5.Utilities.TestBase;
import com.github.javafaker.Faker;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {


    Faker faker=new Faker();
    String fakername=faker.address().firstName();
    String fakerlastname=faker.address().lastName();
    String fakerFullNmae=fakername+" "+fakerlastname;
    String fakeremail=faker.internet().emailAddress();
    String fakerPassword=faker.internet().password();
    String fakeraddress=faker.address().streetAddress();
    String fakercity=faker.address().city();
    String fakerstate=faker.address().state();
    String fakerphonenumber=faker.phoneNumber().cellPhone();
    String fakerZipCode=faker.address().zipCode();
    String fakeZip=fakerZipCode.substring(0,5);


    @Test
    public void RegistrationTest() {
        extentLogger = report.createTest("Registration Test");
        extentLogger.info("3. Click Signin link");
        pages.loginPage().SignInButton.click();

        extentLogger.info("4. Enter new valid email to the email field");
        extentLogger.info("5. Click on Create Account");
        pages.loginPage().EmailToCreateNewAccount.sendKeys(fakeremail + Keys.ENTER);

        extentLogger.info("6. Verify that that email linkd isplays current email");
        //  Assert.assertEquals(fakeremail,pages.loginPage().CheckEmailIsRight.getAttribute("value"));

        extentLogger.info("7. Fill out all the required steps");
        extentLogger.info("Enter first name");
        pages.loginPage().firstNameToRegister.sendKeys(fakername);

        extentLogger.info("Enter last name");
        pages.loginPage().lastnameToRegister.sendKeys(fakerlastname);

        extentLogger.info("enter password");
        pages.loginPage().NewPasswordToRegister.sendKeys(fakerPassword);

        extentLogger.info(" enter addres");
        pages.loginPage().addresss.sendKeys(fakeraddress);

        extentLogger.info("  enter city");
        pages.loginPage().city.sendKeys(fakercity);

        extentLogger.info("enter state");
        pages.loginPage().state.sendKeys(fakerstate);

        extentLogger.info("enter phonenumber");
        pages.loginPage().phoneNum.sendKeys(fakerphonenumber);

        extentLogger.info(" Enter zipcode");
        pages.loginPage().zipCode.sendKeys(fakeZip);


        extentLogger.info("8. Click on Register");
        pages.loginPage().registerButton.click();

        extentLogger.info("9. Verify  that correct first and lastname isdisplayed correctly ontop right");
        Assert.assertEquals(pages.loginPage().nameOnToppofAccount.getText(), fakerFullNmae);

        extentLogger.info("10. Click on My personal information");
        pages.loginPage().clickOnpersonalInfo.click();

        extentLogger.info("11. Verify that personal information is displayed correctly");
        Assert.assertEquals(fakername, pages.loginPage().checkFirstName.getAttribute("value"));
        Assert.assertEquals(fakerlastname, pages.loginPage().checkLastName.getAttribute("value"));
        Assert.assertEquals(fakeremail, pages.loginPage().Checkemail.getAttribute("value"));

        extentLogger.info("12. Click on Back to your account");
        pages.loginPage().backToAccount.click();

        extentLogger.info("13. Click on My addresses verify that address information is displayed correctly");
        pages.loginPage().clickOnAddress.click();

        extentLogger.info("check full name is correct");
        String nameOnTheAddress = pages.loginPage().NameOnTheAddress.getText() + " " + pages.loginPage().lastNameOnTheAddress.getText();
        Assert.assertEquals(fakerFullNmae, nameOnTheAddress);

        extentLogger.info("check street address is correct");
        Assert.assertEquals(fakeraddress, pages.loginPage().streetAddress.getText());

        extentLogger.info("check city is correct");
        String saveAllAddres = pages.loginPage().allAddress.getText();
        String cityAfterSubString = saveAllAddres.substring(0, saveAllAddres.indexOf(","));
        Assert.assertEquals(fakercity, cityAfterSubString);

        extentLogger.info("check zipcode is correct");

        String zipCorrectOne = saveAllAddres.replaceAll("\\D+", "");
        Assert.assertEquals(zipCorrectOne, fakeZip);

        extentLogger.info("check state is correct");
        String stateCorrect = saveAllAddres.substring(saveAllAddres.indexOf(",") + 1, saveAllAddres.length() - 5);
        Assert.assertEquals(fakerstate.trim(), stateCorrect.trim());


        extentLogger.info("14. Click on sign out link");
        pages.loginPage().signOutLink.click();

        extentLogger.info("15. Login using the email and password if the current user");
        pages.loginPage().loginUsingValidEmail.sendKeys(fakeremail);
        pages.loginPage().loginUsingValidPass.sendKeys(fakerPassword + Keys.ENTER);

        extentLogger.info("16. Verify that correct first and last name is displayed correctly on top right");
        Assert.assertEquals(fakerFullNmae, pages.loginPage().nameOnToppofAccount.getText());


    }
    @Test
    public void ErrorMessageValidation() {
        extentLogger = report.createTest("Error Message Validation: First name");

        extentLogger.info("3. Click Signin link");
        pages.loginPage().SignInButton.click();

        extentLogger.info("4. Enter new valid email to the email field");
        extentLogger.info("5. Click on Create Account");
        pages.loginPage().EmailToCreateNewAccount.sendKeys(fakeremail + Keys.ENTER);

        extentLogger.info("6. Fill all the required steps except for firstname");

        extentLogger.info("Enter last name");
        pages.loginPage().lastnameToRegister.sendKeys(fakerlastname);

        extentLogger.info("enter password");
        pages.loginPage().NewPasswordToRegister.sendKeys(fakerPassword);

        extentLogger.info(" enter addres");
        pages.loginPage().addresss.sendKeys(fakeraddress);

        extentLogger.info("  enter city");
        pages.loginPage().city.sendKeys(fakercity);

        extentLogger.info("enter state");
        pages.loginPage().state.sendKeys(fakerstate);

        extentLogger.info("enter phonenumber");
        pages.loginPage().phoneNum.sendKeys(fakerphonenumber);

        extentLogger.info(" Enter zipcode");
        pages.loginPage().zipCode.sendKeys(fakeZip);


        extentLogger.info("7. Click on Register");
        pages.loginPage().registerButton.click();

        extentLogger.info("8. Verify that error messagefirstname isrequired. isdisplayed");
        Assert.assertTrue(pages.loginPage().errorMessage.isDisplayed());


    }
    @Test
    public void CartDetails() throws InterruptedException {
        extentLogger = report.createTest("Error Message Validation: First name");

        extentLogger.info("3.  Click on any product that is not on sale");
                    String product;
                    String price;
                    int k = randomNumber(0, pages.productInfoPage().clickAnyPdt.size() - 1);
                    product = pages.productInfoPage().productName.get(k).getText();
                    price = pages.productInfoPage().productPrice.get(k).getText().replace("$","");
                    Double priceofSingleProduct=Double.parseDouble(price);
                    actions.moveToElement(pages.productInfoPage().clickAnyPdt.get(k)).doubleClick().perform();



        extentLogger.info(" 4. Enter arandom quantity between 2 and 5");
        BrowserUtils.selectRandomTextFromDropdown(pages.addToCarts().selects());


                     switch(k){
                         case 1:
                         pages.addToCarts().addIcon.click();
                         break;
                        case 2:
                             pages.addToCarts().addIcon.click();
                             pages.addToCarts().addIcon.click();

                           break;
                         case 3:
                           pages.addToCarts().addIcon.click();
                           pages.addToCarts().addIcon.click();
                           pages.addToCarts().addIcon.click();
                           break;
                         case 4:
                             pages.addToCarts().addIcon.click();
                             pages.addToCarts().addIcon.click();
                             pages.addToCarts().addIcon.click();
                             pages.addToCarts().addIcon.click();

                     }

        extentLogger.info("6. Click on add to cart");
        pages.addToCarts().addAProductToTheCart.click();

        extentLogger.info("7. Verify confirmation message Product successfully added to your shopping cart");
       Assert.assertEquals(pages.addToCarts().succesMessage.getAttribute("innerText").trim(),"Product successfully added to your shopping cart");

       extentLogger.info("8. Dismiss the confirmation window by clicking on the x icon");
       pages.addToCarts().xbutton.click();

       Thread.sleep(1000);
       extentLogger.info("9. Click on the company logo");
       pages.addToCarts().companyLogo.click();

        extentLogger.info("10. Click on any product that is on sale");
        int l = randomNumber(5, pages.productInfoPage().clickAnyPdt.size()-1);
        String price1=pages.productInfoPage().productPrice.get(l).getAttribute("innerText").replace("$","");
        Double priceofSingleProduct1=Double.parseDouble(price1);
        pages.productInfoPage().clickAnyPdt.get(l).click();

        extentLogger.info("11. Enter a random quantity between 2 and 5");
        BrowserUtils.selectRandomTextFromDropdown(pages.addToCarts().selects());

extentLogger.info("12. Select a different size");
        switch(k){
            case 1:
                pages.addToCarts().addIcon.click();
                break;
            case 2:
                pages.addToCarts().addIcon.click();
                pages.addToCarts().addIcon.click();

                break;
            case 3:
                pages.addToCarts().addIcon.click();
                pages.addToCarts().addIcon.click();
                pages.addToCarts().addIcon.click();
                break;
            case 4:
                pages.addToCarts().addIcon.click();
                pages.addToCarts().addIcon.click();
                pages.addToCarts().addIcon.click();
                pages.addToCarts().addIcon.click();

        }

        extentLogger.info("13. Click on add to cart");
        pages.addToCarts().addAProductToTheCart.click();

         extentLogger.info("14. Verify confirmation message Product successfully added to your shopping cart");
        Assert.assertEquals( pages.addToCarts().succesMessage.getAttribute("innerText").trim(),"Product successfully added to your shopping cart");

         extentLogger.info("15. Dismiss the confirmation window by clicking on the x icon");
         pages.addToCarts().xbutton.click();

         extentLogger.info("16. Hover over the Cart icon");
         actions.moveToElement(pages.addToCarts().hoverOverCart1).clickAndHold().perform();

     extentLogger.info("17. Verify that correct total is displayed");
                     String totalPriceInTheCart=pages.addToCarts().totalPrice.getAttribute("innerText").replace("$","");
                     Double totalPriceOfTheCart=Double.parseDouble(totalPriceInTheCart);

                     String priceOf1Prdct=pages.addToCarts().pricePdt1.getAttribute("innerText").replace("$","");
                     Double priceOfThe1Product=Double.parseDouble(priceOf1Prdct);

                     String priceOf2Prdct=pages.addToCarts().pricePdt2.getAttribute("innerText").replace("$","");
                     Double priceOfThe2Product= Double.parseDouble(priceOf2Prdct);

                     String ShiipingPrice=pages.addToCarts().shippingPrice.getAttribute("innerText").replace("$","");
                     Double ShiipingPric=Double.parseDouble(ShiipingPrice);

                   Assert.assertEquals(totalPriceOfTheCart,(priceOfThe1Product+priceOfThe2Product+ShiipingPric));


extentLogger.info("18. Verify that total is correct based on the price and item count of the products you added to cart. (Shipping is always $2)");

        String quantityInCArt1=pages.addToCarts().cartQuantitiy.get(0).getAttribute("innerText");
        Integer quantity1=Integer.parseInt(quantityInCArt1);
        String quantityInCArt2=pages.addToCarts().cartQuantitiy.get(1).getAttribute("innerText");
        Integer quantity2=Integer.parseInt(quantityInCArt2);

        System.out.println(price );
        Double QuantityTimesPrice=priceofSingleProduct*( quantity1)+ priceofSingleProduct1*( quantity2)+ShiipingPric;
        Assert.assertEquals(totalPriceOfTheCart,QuantityTimesPrice);



























    }
}
