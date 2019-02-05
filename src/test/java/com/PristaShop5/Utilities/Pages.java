package com.PristaShop5.Utilities;


import com.PristaShop5.pages.AddToCarts;
import com.PristaShop5.pages.Homepage;
import com.PristaShop5.pages.LoginPage;
import com.PristaShop5.pages.ProductInfoPage;

public class Pages {

    private Homepage homepage;
    private ProductInfoPage productInfoPage;
    private AddToCarts addToCarts;
    private LoginPage loginPage;

    public Homepage homepage(){
        if(homepage==null){
            homepage=new Homepage();

            }
            return homepage;
        }
        public ProductInfoPage productInfoPage(){
        if(productInfoPage==null){
            productInfoPage=new ProductInfoPage();
        }
        return productInfoPage;
        }
        public AddToCarts addToCarts(){
        if(addToCarts==null){
            addToCarts=new AddToCarts();
        }
        return addToCarts;
        }
        public LoginPage loginPage(){
        if(loginPage==null){
            loginPage=new LoginPage();
        }
        return loginPage;
        }
    }

