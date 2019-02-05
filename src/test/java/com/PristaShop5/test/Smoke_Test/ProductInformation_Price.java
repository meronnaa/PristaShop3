package com.PristaShop5.test.Smoke_Test;

import com.PristaShop5.Utilities.ApplicationConstants;
import com.PristaShop5.Utilities.BrowserUtils;
import com.PristaShop5.Utilities.ConfigurationReader;
import com.PristaShop5.Utilities.TestBase;
import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.security.krb5.internal.PAData;

import java.util.List;
import java.util.Random;

public class ProductInformation_Price extends TestBase {
 String product;
 String price;

    @Test
    public void ProductInformation_Price() {


                int k = randomNumber(0, pages.productInfoPage().clickAnyPdt.size() - 1);
                product = pages.productInfoPage().productName.get(k).getText();
                System.out.println(product);
                price = pages.productInfoPage().productPrice.get(k).getText();


                extentLogger = report.createTest("Product information - price:");
                extentLogger.info("2. Click on any product");
                actions.moveToElement(pages.productInfoPage().clickAnyPdt.get(k)).doubleClick().perform();


                extentLogger.info("3. Verify that same name and price displayed as on the homepage");
                Assert.assertEquals(product, pages.addToCarts().nameAfterAddProduct.getAttribute("innerText"));


                extentLogger = report.createTest("Product information - details:");
                extentLogger.info("4. that default quantity is 1");
                Assert.assertEquals(pages.addToCarts().defaultQuantity.getAttribute("value"), "1");

                extentLogger.info("5. Verify that default sizeis S");
                Assert.assertEquals(pages.addToCarts().defaultSize.getAttribute("innerText"), "S");


                extentLogger.info("6. Verify that size options are S,M,L");

                    Assert.assertEquals(pages.addToCarts().sizes.get(0).getText(),"S");
                    Assert.assertEquals(pages.addToCarts().sizes.get(1).getText(),"M");
                    Assert.assertEquals(pages.addToCarts().sizes.get(2).getText(),"L");


               extentLogger =report.createTest("Product information – Add to cart:");
               extentLogger.info("7. ClickonAddtocart");
               pages.addToCarts().addAProductToTheCart.click();

                 extentLogger.info("8. Verify confirmation message “Product successfully added to your shopping cart”");
                Assert.assertEquals(ApplicationConstants.PRODUCT_SUCCESFULY_ADDEDMESSAGE,pages.addToCarts().succesMessage.getAttribute("innerText").trim());

                extentLogger.info("9. that default quantity is 1");
                 Assert.assertEquals(pages.addToCarts().defaultQuantity.getAttribute("value"),"1");

                extentLogger.info("10. Verify that default size is S");
                Assert.assertEquals(pages.addToCarts().defaultSize.getAttribute("innerText"),"S");

                extentLogger.info("11. Verify that same name and price displayed as on the home page");
               Assert.assertEquals(product, pages.addToCarts().nameAfterAddProduct.getAttribute("innerText"));


    }
    @Test
    public void Loginmyaccount(){
                extentLogger=report.createTest("Login: my account");

                extentLogger.info("2. Click Signin link");
                pages.loginPage().SignInButton.click();

                extentLogger.info("3. Login us ingvalid username and password");
               pages.loginPage().emailaddress.sendKeys(ConfigurationReader.getProperty("username"));
               pages.loginPage().password.sendKeys(ConfigurationReader.getProperty("password")+Keys.ENTER);

               extentLogger.info("4. Verify that title contains Myaccount");
              Assert.assertTrue( pages.loginPage().myAccount.getText().contains("My account"));

              extentLogger.info("5. Verify that account holder full name is displayed next to the Signout link");
              Assert.assertTrue(pages.loginPage().nameOnTop.isDisplayed());


              extentLogger=report.createTest("Login: My personal information");
              extentLogger.info("6. Click on Mypersonal information button");
              pages.loginPage().mypersonalInfoButton.click();

              extentLogger.info("7. Verify title contains Identity");
              Assert.assertTrue(driver.getTitle().contains("Identity"));

              extentLogger.info("8. Verify that first name and last name matches the full name on top");
              String fullName=pages.loginPage().firstname.getAttribute("value")+ " "+pages.loginPage().lastName.getAttribute("value");
               Assert.assertEquals(pages.loginPage().nameOnTop.getAttribute("innerText"),fullName);

               extentLogger.info("9. Click on Save button");
               pages.loginPage().saveButton.click();

               extentLogger.info("10. Verify error message “The password you entered is incorrect.”");
              Assert.assertTrue( pages.loginPage().errorMessage.getText().contains("The password you entered is incorrect."));


               extentLogger.info("11. Click on Back to your account");
               pages.loginPage().backToAccount.click();

               extentLogger.info("12. Verify that title contains My account");
               Assert.assertTrue(pages.loginPage().myAccount.getText().contains("My account"));

               extentLogger=report.createTest("Login: My addresses");
               extentLogger.info("13. Click on My addresses");
               pages.loginPage().myaddress.click();

               extentLogger.info("14. Click on Add a new address");
               pages.loginPage().addNewAddres.click();

               extentLogger.info("15. Verify that first name and last name matches the full name on top");
                Assert.assertEquals(pages.loginPage().nameOnTop.getAttribute("innerText"),fullName);

                extentLogger.info("16. Delete the first name");
                pages.loginPage().firstname.clear();

                extentLogger.info("17. Click save");
                pages.loginPage().saveButton.click();

                extentLogger.info("18. Verify error message “firstname is required.”");
                Assert.assertEquals(pages.loginPage().errorMessage.getText(),"firstname is required.");































    }
}