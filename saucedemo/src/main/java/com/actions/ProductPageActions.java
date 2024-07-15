package com.actions;
import com.locators.ProductPageLocators;
import com.utils.HelperClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductPageActions {
	ProductPageLocators productPageLocators = null;
	 
    public ProductPageActions() {
 
        this.productPageLocators = new ProductPageLocators();
        PageFactory.initElements(HelperClass.getDriver(),productPageLocators);
    }
 
    // Get the User Title from product Page
    public String getProuctPageText() {
        return productPageLocators.productPageTitle.getText();
    }
    // Click on berger menu
    public WebElement getBurgerMenu() {
        return productPageLocators.burgerMenu;
    }
 
}
