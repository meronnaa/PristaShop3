package com.PristaShop5.test.Functional_Test;

import com.PristaShop5.Utilities.ConfigurationReader;
import com.PristaShop5.Utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.misc.ASCIICaseInsensitiveComparator;

public class CartLoginTest extends TestBase {

String product;

    @Test
    public void CartLoginTest() {

        String price;

        extentLogger = report.createTest(" Cart Login Test");
        extentLogger.info("3. Add any product in the homepage to the cart");
        int l = randomNumber(0, pages.productInfoPage().clickAnyPdt.size() - 1);
        product = pages.productInfoPage().productName.get(l).getAttribute("innerText");
        price = pages.productInfoPage().productPrice.get(l).getAttribute("innerText").replace("$", "");

        pages.productInfoPage().clickAnyPdt.get(l).click();
        pages.addToCarts().addAProductToTheCart.click();

        extentLogger.info("4. Hover over the cart icon");
        actions.moveToElement(pages.addToCarts().hoverOverCart1).clickAndHold().perform();

        extentLogger.info("5. Verify that cart contains the product");
        Assert.assertEquals(product, pages.addToCarts().productnameInTheCart.getAttribute("title"));
        pages.addToCarts().proceedtocart.click();

        extentLogger.info("6. Login as any valid user");
        pages.addToCarts().sigIn.click();
        pages.loginPage().login();


        extentLogger.info("7. Hoverover the cart icon");
        actions.moveToElement(pages.addToCarts().hoverOverCart1).clickAndHold().perform();

        extentLogger.info("8. Verify that cart information is same as step5");
        Assert.assertEquals(product, pages.addToCarts().productnameInTheCart.getAttribute("title"));
    }

    @Test
    public void CartLogoutTest() {

        extentLogger = report.createTest("Cart Logout Test");
        extentLogger.info("3. Login as any valid user");
        pages.loginPage().login();

        extentLogger.info("4. Go back to homepage");
        pages.addToCarts().backToHomePage.click();

        extentLogger.info("5. Add any product in the homepage to the cart");
        int k = randomNumber(0, pages.productInfoPage().clickAnyPdt.size() - 1);
        product = pages.productInfoPage().productName.get(k).getAttribute("innerText");
        pages.productInfoPage().clickAnyPdt.get(k).click();
        pages.addToCarts().addAProductToTheCart.click();
        pages.addToCarts().proceedtocart.click();

        extentLogger.info("6. Hoverover the cart icon");
        actions.moveToElement(pages.addToCarts().hoverOverCart1).clickAndHold().perform();

        extentLogger.info("7. Verify that cart contains the product");
        Assert.assertEquals(product, pages.addToCarts().productnameInTheCart.getAttribute("title"));

        extentLogger.info("8. Logout");
        pages.addToCarts().logout.click();

        extentLogger.info("9. Verify the cart contains the word empty");
        Assert.assertTrue(pages.addToCarts().emptyMessage.getText().contains("empty"));


    }
        @Test
        public void CartIconDeleteTest(){

        extentLogger=report.createTest("Cart Icon Delete Test");
        extentLogger.info("3. Add any product in the home page to the cart");
            int k = randomNumber(0, pages.productInfoPage().clickAnyPdt.size() - 1);
            product = pages.productInfoPage().productName.get(k).getAttribute("innerText");
            pages.productInfoPage().clickAnyPdt.get(k).click();
            pages.addToCarts().addAProductToTheCart.click();


            extentLogger.info("4. Click on Continue shopping");
            pages.addToCarts().continueshopping.click();

            extentLogger.info("5. Hover over the cart icon");
            actions.moveToElement(pages.addToCarts().hoverOverCart1).clickAndHold().perform();

            extentLogger.info("6. Click the x to delete the product");
            pages.addToCarts().xIconOnTheCart.click();

            extentLogger.info("7. Verify word empty is displayed in the Cart icon");
           Assert.assertTrue(pages.addToCarts().emptyMessageInTheCart.getAttribute("innerText").contains("empty"));

    }
    @Test
    public void CartCheckoutDeleteTest() throws InterruptedException {

        extentLogger=report.createTest("Cart Checkout Delete Test");
        extentLogger.info("3. Add any product in the homepage to the cart");
        int k = randomNumber(0, pages.productInfoPage().clickAnyPdt.size() - 1);
        int l=randomNumber(0, pages.productInfoPage().clickAnyPdt.size() - 1);
        product = pages.productInfoPage().productName.get(k).getAttribute("innerText");
        pages.productInfoPage().clickAnyPdt.get(k).click();
        pages.addToCarts().addAProductToTheCart.click();

        extentLogger.info("4. Click on Continue shopping");
        pages.addToCarts().continueshopping.click();

        driver.navigate().back();

        extentLogger.info("5. Add another product in the home page to the cart");
        pages.productInfoPage().clickAnyPdt.get(l).click();
        pages.addToCarts().addAProductToTheCart.click();

        extentLogger.info("6. Click on Proceed to checkout");
        pages.addToCarts().proceedtocart.click();

        extentLogger.info("7. Verify message Your shopping cart contains:2Products");
        Assert.assertTrue(pages.addToCarts().messageOfCartContent.getText().contains("Your shopping cart contains: 2 Products"));

        extentLogger.info("8. Click the delete icon to delete one of the products");
        pages.addToCarts().delete1Pdt.click();

        extentLogger.info("9. Verify message Your shopping cart contains:1 Product");
        Thread.sleep(1000);
        System.out.println( pages.addToCarts().messageOfCartContent.getText());
       Assert.assertTrue( pages.addToCarts().messageOfCartContent.getText().contains("Your shopping cart contains: 1 Product"));


        extentLogger.info("10.Click the delete icon to delete the second product");
        pages.addToCarts().delete1Pdt.click();

        extentLogger.info("11. Verify message Your shopping cart is empty.");
        Assert.assertTrue(pages.addToCarts().emptyMessage.getAttribute("innerText").contains("Your shopping cart is empty."));



















    }









}
